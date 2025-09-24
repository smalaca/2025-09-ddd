package com.smalaca.trainingoffer.infrastructure.repository.jpa.trainingproposition;

import com.smalaca.trainingoffer.domain.trainingproposition.TrainingProposition;
import com.smalaca.trainingoffer.domain.trainingproposition.TrainingPropositionRepository;

import java.util.Optional;
import java.util.UUID;

public class JpaTrainingPropositionRepository implements TrainingPropositionRepository {
    @Override
    public void save(TrainingProposition trainingProposition) {

    }

    @Override
    public TrainingProposition findById(UUID trainingPropositionId) {
        Optional<TrainingProposition> found = findInDatabaseById(trainingPropositionId);

        if (found.isEmpty()) {
            throw new IllegalArgumentException("Training proposition not found");
        }

        return found.get();
    }

    private Optional<TrainingProposition> findInDatabaseById(UUID trainingPropositionId) {
        return null;
    }
}
