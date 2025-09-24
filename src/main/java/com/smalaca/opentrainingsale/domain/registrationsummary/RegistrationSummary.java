package com.smalaca.opentrainingsale.domain.registrationsummary;

import com.smalaca.opentrainingsale.domain.sale.Sale;

import java.util.UUID;

public class RegistrationSummary {
    private UUID registrationSummaryId;
    private UUID trainingId;
    private UUID participantId;
    private RegistrationSummaryStatus status;

    public UUID trainingId() {
        return trainingId;
    }

    public UUID participantId() {
        return participantId;
    }

    public Sale confirm() {
        status = RegistrationSummaryStatus.CONFIRMED;
        return new Sale(registrationSummaryId, trainingId, participantId);
    }
}
