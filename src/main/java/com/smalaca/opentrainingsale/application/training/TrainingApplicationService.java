package com.smalaca.opentrainingsale.application.training;

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

        Training training = new Training(trainingCode, price);

        trainingRepository.save(training);
    }
}
