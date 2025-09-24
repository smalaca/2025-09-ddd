package com.smalaca.opentrainingsale.domain.cart;

import java.util.List;
import java.util.UUID;

public class Cart {
    private UUID cartId;
    private List<UUID> trainings;

    public void add(UUID trainingId) {
        trainings.add(trainingId);
    }

    public void remove(UUID trainingId) {
        trainings.remove(trainingId);
    }
}
