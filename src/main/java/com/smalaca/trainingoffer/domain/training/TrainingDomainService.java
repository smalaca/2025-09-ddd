package com.smalaca.trainingoffer.domain.training;

import java.util.UUID;

public class TrainingDomainService {
    public void switchGuardians(Training trainingOne, Training trainingTwo) {
        UUID guardianIdOne = trainingOne.guardianId();
        UUID guardianIdTwo = trainingTwo.guardianId();
        trainingOne.updateGuardian(guardianIdTwo);
        trainingTwo.updateGuardian(guardianIdOne);
    }
}
