package com.smalaca.trainingoffer.domain.trainingproposition;

import java.util.UUID;

// value object
public class PropositionNumber {
    private final String value;

    private PropositionNumber(String value) {
        this.value = value;
    }

    // factory
    static PropositionNumber create(String trainerCode) {
        return new PropositionNumber(trainerCode + "PR" + UUID.randomUUID());
    }
}
