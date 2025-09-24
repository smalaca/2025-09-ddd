package com.smalaca.opentrainingsale.domain.trainingregistration;

public record RegistrationConfirmedDto(com.smalaca.opentrainingsale.domain.cart.Cart cart,
                                       com.smalaca.opentrainingsale.domain.training.Training training,
                                       com.smalaca.opentrainingsale.domain.registrationsummary.RegistrationSummary registrationSummary) {
}
