package com.smalaca.trainingoffer.domain.trainingproposition;

// factory
public class TrainingPropositionFactory {
    public TrainingProposition create(TrainingPropositionDto dto) {
        return new TrainingProposition(dto.trainerId(), dto.title(), dto.description());
    }
}
