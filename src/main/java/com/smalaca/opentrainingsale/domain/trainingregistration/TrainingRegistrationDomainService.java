package com.smalaca.opentrainingsale.domain.trainingregistration;

import com.smalaca.opentrainingsale.domain.cart.Cart;
import com.smalaca.opentrainingsale.domain.registrationsummary.RegistrationSummary;
import com.smalaca.opentrainingsale.domain.training.Training;

import java.util.UUID;

public class TrainingRegistrationDomainService {
    public RegistrationConfirmedDto confirm(Cart cart, Training training, UUID participantId) {
        cart.remove(training.trainingId());
        RegistrationSummary registrationSummary = training.register(participantId);

        return new RegistrationConfirmedDto(cart, training, registrationSummary);
    }
}
