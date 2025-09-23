package com.smalaca.opentrainingsale.application.cart;

import com.smalaca.opentrainingsale.domain.cart.Cart;
import com.smalaca.opentrainingsale.domain.cart.CartRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartApplicationService {
    private final CartRepository cartRepository;

    public CartApplicationService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addToCart(UUID cartId) {
        Cart cart = cartRepository.findById(cartId);

        cart.add();

        cartRepository.save(cart);
    }
}
