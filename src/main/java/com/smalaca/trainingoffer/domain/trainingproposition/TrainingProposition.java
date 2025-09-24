package com.smalaca.trainingoffer.domain.trainingproposition;

import com.smalaca.trainingoffer.domain.trainingcatalogue.TrainingCatalogue;
import com.smalaca.trainingoffer.domain.trainingtemplate.TrainingTemplate;

import java.util.UUID;

// aggregate root
public class TrainingProposition {
    private UUID trainingPropositionId;
    private final PropositionNumber propositionNumber;
    private final String trainerCode;
    private final String title;
    private final String description;
    private TrainingPropositionStatus status;
    private UUID reviewerId;

    TrainingProposition(
            PropositionNumber propositionNumber, String trainerCode, String title, String description) {
        this.propositionNumber = propositionNumber;
        this.trainerCode = trainerCode;
        this.title = title;
        this.description = description;
    }

    // factory
    public TrainingTemplate accept(UUID reviewerId, TrainingCatalogue trainingCatalogue) {
        if (trainingCatalogue.isAllowedToReview(reviewerId)) {
            this.status = TrainingPropositionStatus.ACCEPTED;
            this.reviewerId = reviewerId;

            return TrainingTemplate.create(trainingPropositionId, title, description, trainerCode);
        } else {
            throw new TrainingPropositionException("Reviewer: " + reviewerId + " not allowed to accept training proposition: " + trainingPropositionId);
        }
    }
}
