package com.smalaca.trainingoffer.application.training;

import com.smalaca.trainingoffer.domain.training.Training;
import com.smalaca.trainingoffer.domain.training.TrainingRepository;
import jakarta.transaction.Transactional;

import java.util.UUID;

public class TrainingApplicationService {
    private final TrainingRepository trainingRepository;

    public TrainingApplicationService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Transactional
    public void switchGuardians(UUID trainingIdOne, UUID trainingIdTwo) {
        Training trainingOne = trainingRepository.findById(trainingIdOne);
        Training trainingTwo = trainingRepository.findById(trainingIdTwo);

        UUID guardianIdOne = trainingOne.guardianId();
        UUID guardianIdTwo = trainingTwo.guardianId();
        trainingOne.updateGuardian(guardianIdTwo);
        trainingTwo.updateGuardian(guardianIdOne);

        trainingRepository.save(trainingOne);
        trainingRepository.save(trainingTwo);
    }
}
