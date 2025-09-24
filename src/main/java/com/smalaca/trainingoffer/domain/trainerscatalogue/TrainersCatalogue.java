package com.smalaca.trainingoffer.domain.trainerscatalogue;

import java.util.UUID;

public interface TrainersCatalogue {
    boolean isAllowedToReview(UUID reviewerId);
}
