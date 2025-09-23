package com.smalaca.opentrainingsale.infrastructure.session.http;

import com.smalaca.opentrainingsale.domain.cart.Cart;
import jakarta.servlet.http.HttpSession;

import java.util.UUID;

public class HttpSessionWrapper {
    private static final String CART_ID = "cartId";
    private final HttpSession httpSession;

    public HttpSessionWrapper(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public UUID getCartId() {
        if (httpSession.getAttribute(CART_ID) == null) {
            httpSession.setAttribute(CART_ID, UUID.randomUUID());
        }

        return (UUID) httpSession.getAttribute(CART_ID);
    }

    public boolean hasNoCart() {
        return false;
    }

    public void setCart(Cart cart) {

    }

    public Cart getCart() {
        return null;
    }
}
