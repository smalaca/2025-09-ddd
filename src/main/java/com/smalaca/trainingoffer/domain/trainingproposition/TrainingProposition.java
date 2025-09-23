package com.smalaca.trainingoffer.domain.trainingproposition;

import java.util.UUID;

// aggregate root
public class TrainingProposition {
    private final UUID trainerId;
    private final String title;
    private final String description;

    public TrainingProposition(UUID trainerId, String title, String description) {
        this.trainerId = trainerId;
        this.title = title;
        this.description = description;
    }
}
