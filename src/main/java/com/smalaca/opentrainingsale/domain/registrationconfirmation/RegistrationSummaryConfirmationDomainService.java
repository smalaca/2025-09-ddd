package com.smalaca.opentrainingsale.domain.registrationconfirmation;

import com.smalaca.opentrainingsale.domain.registrationsummary.RegistrationSummary;
import com.smalaca.opentrainingsale.domain.sale.Sale;
import com.smalaca.opentrainingsale.domain.training.Training;

public class RegistrationSummaryConfirmationDomainService {
    public RegistrationSummaryConfirmedDto confirm(RegistrationSummary registrationSummary, Training training) {
        Sale sale = registrationSummary.confirm();
        training.confirmAttendance(registrationSummary.participantId());

        return new RegistrationSummaryConfirmedDto(registrationSummary, training, sale);
    }
}
