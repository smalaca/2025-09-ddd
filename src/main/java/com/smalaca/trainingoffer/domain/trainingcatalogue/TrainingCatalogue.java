package com.smalaca.trainingoffer.domain.trainingcatalogue;

import java.util.UUID;

public interface TrainingCatalogue {
    boolean isAllowedToReview(UUID reviewerId);
}
