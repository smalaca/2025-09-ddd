package com.smalaca.trainingoffer.domain.trainingproposition;

import java.util.UUID;

// repository
public interface TrainingPropositionRepository {
    void save(TrainingProposition trainingProposition);

    TrainingProposition findById(UUID trainingPropositionId);
}
