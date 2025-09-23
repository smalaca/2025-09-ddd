package com.smalaca.opentrainingsale.domain.training;

public class Training {
    private final TrainingCode trainingCode;
    private final Price price;

    public Training(TrainingCode trainingCode, Price price) {
        this.trainingCode = trainingCode;
        this.price = price;
    }
}
