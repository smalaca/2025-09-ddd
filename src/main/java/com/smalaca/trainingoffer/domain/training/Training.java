package com.smalaca.trainingoffer.domain.training;

import java.util.UUID;

// aggregate root
public class Training {
    private UUID guardianId;

    public UUID guardianId() {
        return guardianId;
    }

    public void updateGuardian(UUID guardianId) {
        this.guardianId = guardianId;
    }
}
