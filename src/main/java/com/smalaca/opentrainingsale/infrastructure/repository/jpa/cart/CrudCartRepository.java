package com.smalaca.opentrainingsale.infrastructure.repository.jpa.cart;

import com.smalaca.opentrainingsale.domain.cart.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface CrudCartRepository extends CrudRepository<Cart, UUID> {
}
