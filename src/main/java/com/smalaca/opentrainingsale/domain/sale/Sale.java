package com.smalaca.opentrainingsale.domain.sale;

import com.smalaca.opentrainingsale.domain.price.Price;

import java.util.UUID;

public class Sale {
    private final UUID registrationSummaryId;
    private final UUID trainingId;
    private final UUID participantId;
    private final Price price;

    public Sale(UUID registrationSummaryId, UUID trainingId, UUID participantId, Price price) {
        this.registrationSummaryId = registrationSummaryId;
        this.trainingId = trainingId;
        this.participantId = participantId;
        this.price = price;
    }
}
