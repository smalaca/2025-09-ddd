package com.smalaca.opentrainingsale.application.cart;

import com.smalaca.opentrainingsale.domain.cart.Cart;
import com.smalaca.opentrainingsale.domain.cart.CartRepository;
import com.smalaca.opentrainingsale.domain.registrationsummary.RegistrationSummary;
import com.smalaca.opentrainingsale.domain.registrationsummary.RegistrationSummaryRepository;
import com.smalaca.opentrainingsale.domain.training.Training;
import com.smalaca.opentrainingsale.domain.training.TrainingRepository;
import com.smalaca.opentrainingsale.domain.trainingregistration.RegistrationConfirmedDto;
import com.smalaca.opentrainingsale.domain.trainingregistration.TrainingRegistrationDomainService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartApplicationService {
    private final CartRepository cartRepository;
    private final TrainingRepository trainingRepository;
    private final RegistrationSummaryRepository registrationSummaryRepository;
    private final TrainingRegistrationDomainService trainingRegistrationDomainService;

    public CartApplicationService(CartRepository cartRepository, TrainingRepository trainingRepository, RegistrationSummaryRepository registrationSummaryRepository, TrainingRegistrationDomainService trainingRegistrationDomainService) {
        this.cartRepository = cartRepository;
        this.trainingRepository = trainingRepository;
        this.registrationSummaryRepository = registrationSummaryRepository;
        this.trainingRegistrationDomainService = trainingRegistrationDomainService;
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

        RegistrationConfirmedDto dto = trainingRegistrationDomainService.confirm(cart, training, participantId);

        cartRepository.save(dto.cart());
        trainingRepository.save(dto.training());
        registrationSummaryRepository.save(dto.registrationSummary());
    }
}
