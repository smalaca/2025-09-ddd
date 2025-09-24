package com.smalaca.opentrainingsale.infrastructure.api.rest.cart;

import java.util.UUID;

public record AddToCartCommand(UUID cartId, UUID trainingId) {
    boolean hasCardId() {
        return cartId != null;
    }
}
