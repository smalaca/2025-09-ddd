package com.smalaca.trainingoffer.domain.trainingproposition;

// aggregate root
public class TrainingProposition {
    private final PropositionNumber propositionNumber;
    private final String trainerCode;
    private final String title;
    private final String description;

    TrainingProposition(
            PropositionNumber propositionNumber, String trainerCode, String title, String description) {
        this.propositionNumber = propositionNumber;
        this.trainerCode = trainerCode;
        this.title = title;
        this.description = description;
    }
}
