package com.smalaca.opentrainingsale.domain.cart;

import java.util.UUID;

public interface CartRepository {
    Cart findById(UUID cartId);

    void save(Cart cart);
}
