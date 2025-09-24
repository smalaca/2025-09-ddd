package com.smalaca.opentrainingsale.domain.price;

import java.math.BigDecimal;

// value object
public class Price {
    private final BigDecimal price;

    private Price(BigDecimal price) {
        this.price = price;
    }

    // factory
    public static Price from(BigDecimal price) {
        if (BigDecimal.ZERO.compareTo(price) > 0) {
            throw new PriceException(price);
        } else {
            return new Price(price);
        }
    }
}
