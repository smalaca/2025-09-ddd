package com.smalaca.trainingoffer.application.training;

import com.smalaca.trainingoffer.domain.training.Training;
import com.smalaca.trainingoffer.domain.training.TrainingDomainService;
import com.smalaca.trainingoffer.domain.training.TrainingRepository;
import jakarta.transaction.Transactional;

import java.util.UUID;

public class TrainingApplicationService {
    private final TrainingRepository trainingRepository;
    private final TrainingDomainService trainingDomainService;

    public TrainingApplicationService(TrainingRepository trainingRepository, TrainingDomainService trainingDomainService) {
        this.trainingRepository = trainingRepository;
        this.trainingDomainService = trainingDomainService;
    }

    @Transactional
    public void switchGuardians(UUID trainingIdOne, UUID trainingIdTwo) {
        Training trainingOne = trainingRepository.findById(trainingIdOne);
        Training trainingTwo = trainingRepository.findById(trainingIdTwo);

        trainingDomainService.switchGuardians(trainingOne, trainingTwo);

        trainingRepository.save(trainingOne);
        trainingRepository.save(trainingTwo);
    }
}
