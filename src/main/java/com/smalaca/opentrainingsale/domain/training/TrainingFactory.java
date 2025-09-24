package com.smalaca.opentrainingsale.domain.training;

import com.smalaca.opentrainingsale.application.training.TrainingDto;
import com.smalaca.opentrainingsale.domain.trainerscatalogue.TrainersCatalogue;
import com.smalaca.opentrainingsale.domain.trainerscatalogue.TrainingRequestDto;
import com.smalaca.opentrainingsale.domain.trainingoffer.TrainingOffer;

// factory
public class TrainingFactory {
    private final TrainingOffer trainingOffer;
    private final TrainersCatalogue trainersCatalogue;

    public TrainingFactory(TrainingOffer trainingOffer, TrainersCatalogue trainersCatalogue) {
        this.trainingOffer = trainingOffer;
        this.trainersCatalogue = trainersCatalogue;
    }

    public Training create(TrainingDomainDto dto) {
        if (doNotExists(dto.trainingCode())) {
            throw TrainingException.notExistingTrainingCode(dto.trainingCode());
        }

        if (doesTrainerCannotConductTraining(dto)) {
            throw TrainingException.trainerCannotConductTraining(dto);
        }

        return new Training.TrainingBuilder()
                .trainingCode(dto.trainingCode())
                .price(dto.price())
                .period(dto.period())
                .minimumParticipants(dto.minimumParticipants())
                .maximumParticipants(dto.maximumParticipants())
                .build();
    }

    private boolean doesTrainerCannotConductTraining(TrainingDomainDto dto) {
        TrainingRequestDto trainingRequestDto = new TrainingRequestDto(
                dto.trainerId(),
                dto.trainingCode().trainingCode(),
                dto.period().startDate(),
                dto.period().endDate());

        return trainersCatalogue.canTrainerConduct(trainingRequestDto);
    }

    private boolean doNotExists(TrainingCode trainingCode) {
        return !trainingOffer.exists(trainingCode.trainingCode());
    }
}
