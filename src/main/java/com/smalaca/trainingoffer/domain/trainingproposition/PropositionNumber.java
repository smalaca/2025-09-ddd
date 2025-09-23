package com.smalaca.trainingoffer.domain.trainingproposition;

import java.util.UUID;

// value object
public class PropositionNumber {
    private final String propositionNumber;

    private PropositionNumber(String propositionNumber) {
        this.propositionNumber = propositionNumber;
    }

    // factory
    static PropositionNumber create(String trainerCode) {
        return new PropositionNumber(trainerCode + "PR" + UUID.randomUUID());
    }
}
