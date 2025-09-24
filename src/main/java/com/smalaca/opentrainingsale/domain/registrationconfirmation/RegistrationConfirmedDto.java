package com.smalaca.opentrainingsale.domain.registrationconfirmation;

import com.smalaca.opentrainingsale.domain.registrationsummary.RegistrationSummary;
import com.smalaca.opentrainingsale.domain.sale.Sale;
import com.smalaca.opentrainingsale.domain.training.Training;

public record RegistrationConfirmedDto(RegistrationSummary registrationSummary, Training training, Sale sale) {
}
