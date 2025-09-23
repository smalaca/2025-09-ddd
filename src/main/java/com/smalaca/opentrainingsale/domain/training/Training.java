package com.smalaca.opentrainingsale.domain.training;

public class Training {
    private final TrainingCode trainingCode;
    private final Price price;
    private final Period period;

    Training(TrainingCode trainingCode, Price price, Period period) {
        this.trainingCode = trainingCode;
        this.price = price;
        this.period = period;
    }
}
