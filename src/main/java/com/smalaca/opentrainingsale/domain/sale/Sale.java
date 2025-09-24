package com.smalaca.opentrainingsale.domain.sale;

import java.util.UUID;

public class Sale {
    private final UUID registrationSummaryId;
    private final UUID trainingId;
    private final UUID participantId;

    public Sale(UUID registrationSummaryId, UUID trainingId, UUID participantId) {
        this.registrationSummaryId = registrationSummaryId;
        this.trainingId = trainingId;
        this.participantId = participantId;
    }
}
