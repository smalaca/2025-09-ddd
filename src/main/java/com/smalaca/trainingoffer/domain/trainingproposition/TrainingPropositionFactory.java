package com.smalaca.trainingoffer.domain.trainingproposition;

// factory
public class TrainingPropositionFactory {
    public TrainingProposition create(TrainingPropositionDto dto) {
        PropositionNumber propositionNumber = PropositionNumber.create(dto.trainerCode());

        return new TrainingProposition(propositionNumber, dto.trainerCode(), dto.title(), dto.description());
    }
}
