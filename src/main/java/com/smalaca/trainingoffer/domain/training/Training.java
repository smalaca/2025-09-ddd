package com.smalaca.trainingoffer.domain.training;

import java.util.UUID;

// aggregate root
public class Training {
    private UUID guardianId;

    UUID guardianId() {
        return guardianId;
    }

    void updateGuardian(UUID guardianId) {
        this.guardianId = guardianId;
    }
}
