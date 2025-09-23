package com.smalaca.opentrainingsale.domain.training;

// factory
public class TrainingFactory {
    public Training create(TrainingCode trainingCode, Price price, Period period) {
        return new Training(trainingCode, price, period);
    }
}
