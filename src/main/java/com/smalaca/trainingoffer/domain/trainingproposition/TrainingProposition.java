package com.smalaca.trainingoffer.domain.trainingproposition;

// aggregate root
public class TrainingProposition {
    private final String title;
    private final String description;

    public TrainingProposition(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
