package com.smalaca.trainingoffer.domain.training;

import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;

public class TrainingDomainService {
    public List<Training> switchGuardians(Training trainingOne, Training trainingTwo) {
        UUID guardianIdOne = trainingOne.guardianId();
        UUID guardianIdTwo = trainingTwo.guardianId();
        trainingOne.updateGuardian(guardianIdTwo);
        trainingTwo.updateGuardian(guardianIdOne);

        return asList(trainingOne, trainingTwo);
    }
}
