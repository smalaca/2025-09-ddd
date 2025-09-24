package com.smalaca.opentrainingsale.application.cart;

import com.smalaca.opentrainingsale.domain.cart.Cart;
import com.smalaca.opentrainingsale.domain.cart.CartRepository;
import com.smalaca.opentrainingsale.domain.registrationsummary.RegistrationSummary;
import com.smalaca.opentrainingsale.domain.registrationsummary.RegistrationSummaryRepository;
import com.smalaca.opentrainingsale.domain.training.Training;
import com.smalaca.opentrainingsale.domain.training.TrainingRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartApplicationService {
    private final CartRepository cartRepository;
    private final TrainingRepository trainingRepository;
    private final RegistrationSummaryRepository registrationSummaryRepository;

    public CartApplicationService(CartRepository cartRepository, TrainingRepository trainingRepository, RegistrationSummaryRepository registrationSummaryRepository) {
        this.cartRepository = cartRepository;
        this.trainingRepository = trainingRepository;
        this.registrationSummaryRepository = registrationSummaryRepository;
    }

    @Transactional
    public void addToCart(UUID cartId, UUID trainingId) {
        Cart cart = cartRepository.findById(cartId);

        cart.add(trainingId);

        cartRepository.save(cart);
    }

    @Transactional
    public void registerForTraining(UUID participantId, UUID cartId, UUID trainingId) {
        Cart cart = cartRepository.findById(cartId);
        Training training = trainingRepository.findById(trainingId);

        cart.remove(trainingId);
        RegistrationSummary registrationSummary = training.register(participantId);

        cartRepository.save(cart);
        trainingRepository.save(training);
        registrationSummaryRepository.save(registrationSummary);
    }
}
