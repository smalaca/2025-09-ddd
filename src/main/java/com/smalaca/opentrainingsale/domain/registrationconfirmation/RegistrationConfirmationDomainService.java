package com.smalaca.opentrainingsale.domain.registrationconfirmation;

import com.smalaca.opentrainingsale.domain.registrationsummary.RegistrationSummary;
import com.smalaca.opentrainingsale.domain.sale.Sale;
import com.smalaca.opentrainingsale.domain.training.Training;

public class RegistrationConfirmationDomainService {
    public RegistrationConfirmedDto confirm(RegistrationSummary registrationSummary, Training training) {
        Sale sale = registrationSummary.confirm();
        training.confirmAttendance(registrationSummary.participantId());

        return new RegistrationConfirmedDto(registrationSummary, training, sale);
    }
}
