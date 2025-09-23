package com.smalaca.opentrainingsale.application.training;

import com.smalaca.opentrainingsale.domain.training.Training;
import com.smalaca.opentrainingsale.domain.training.TrainingRepository;

public class TrainingApplicationService {
    private final TrainingRepository trainingRepository;

    public TrainingApplicationService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public void addToOffer() {
        Training training = new Training();

        trainingRepository.save(training);
    }
}
