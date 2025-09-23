package com.smalaca.opentrainingsale.application.training;

import com.smalaca.opentrainingsale.domain.training.Period;
import com.smalaca.opentrainingsale.domain.training.Price;
import com.smalaca.opentrainingsale.domain.training.Training;
import com.smalaca.opentrainingsale.domain.training.TrainingCode;
import com.smalaca.opentrainingsale.domain.training.TrainingDomainDto;
import com.smalaca.opentrainingsale.domain.training.TrainingFactory;
import com.smalaca.opentrainingsale.domain.training.TrainingRepository;

public class TrainingApplicationService {
    private final TrainingRepository trainingRepository;
    private final TrainingFactory trainingFactory;

    public TrainingApplicationService(TrainingRepository trainingRepository, TrainingFactory trainingFactory) {
        this.trainingRepository = trainingRepository;
        this.trainingFactory = trainingFactory;
    }

    public void addToOffer(TrainingDto dto) {
        TrainingCode trainingCode = new TrainingCode(dto.trainingCode());
        Price price = new Price(dto.price());
        Period period = new Period(dto.startDate(), dto.endDate());
        TrainingDomainDto trainingDomainDto = new TrainingDomainDto(
                trainingCode, price, period, dto.minimumParticipants(), dto.maximumParticipants());

        Training training = trainingFactory.create(trainingDomainDto);

        trainingRepository.save(training);
    }
}
