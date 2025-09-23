package com.smalaca.opentrainingsale.application.training;

import com.smalaca.opentrainingsale.domain.training.Period;
import com.smalaca.opentrainingsale.domain.training.Price;
import com.smalaca.opentrainingsale.domain.training.Training;
import com.smalaca.opentrainingsale.domain.training.TrainingCode;
import com.smalaca.opentrainingsale.domain.training.TrainingRepository;

public class TrainingApplicationService {
    private final TrainingRepository trainingRepository;

    public TrainingApplicationService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public void addToOffer(TrainingDto dto) {
        TrainingCode trainingCode = new TrainingCode(dto.trainingCode());
        Price price = new Price(dto.price());
        Period period = new Period(dto.startDate(), dto.endDate());

        Training training = new Training(trainingCode, price, period);

        trainingRepository.save(training);
    }
}
