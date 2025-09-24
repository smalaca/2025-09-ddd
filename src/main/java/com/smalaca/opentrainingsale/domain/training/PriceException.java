package com.smalaca.opentrainingsale.domain.training;

import java.math.BigDecimal;

class PriceException extends RuntimeException {
    private final BigDecimal price;

    PriceException(BigDecimal price) {
        this.price = price;
    }
}
