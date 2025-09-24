package com.smalaca.opentrainingsale.domain.training;

import com.smalaca.opentrainingsale.domain.trainingoffer.TrainingOffer;

// factory
public class TrainingFactory {
    private final TrainingOffer trainingOffer;

    public TrainingFactory(TrainingOffer trainingOffer) {
        this.trainingOffer = trainingOffer;
    }

    public Training create(TrainingDomainDto dto) {
        if (doNotExists(dto.trainingCode())) {
            throw TrainingException.notExistingTrainingCode(dto.trainingCode());
        }

        return new Training.TrainingBuilder()
                .trainingCode(dto.trainingCode())
                .price(dto.price())
                .period(dto.period())
                .minimumParticipants(dto.minimumParticipants())
                .maximumParticipants(dto.maximumParticipants())
                .build();
    }

    private boolean doNotExists(TrainingCode trainingCode) {
        return !trainingOffer.exists(trainingCode.trainingCode());
    }
}
