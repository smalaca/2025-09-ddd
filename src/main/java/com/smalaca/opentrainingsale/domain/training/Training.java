package com.smalaca.opentrainingsale.domain.training;

public class Training {
    private final TrainingCode trainingCode;
    private final Price price;
    private final Period period;

    private Training(TrainingBuilder builder) {
        this.trainingCode = builder.trainingCode;
        this.price = builder.price;
        this.period = builder.period;
    }

    // factory
    static class TrainingBuilder {
        private TrainingCode trainingCode;
        private Price price;
        private Period period;

        TrainingBuilder trainingCode(TrainingCode trainingCode) {
            this.trainingCode = trainingCode;
            return this;
        }

        TrainingBuilder price(Price price) {
            this.price = price;
            return this;
        }

        TrainingBuilder period(Period period) {
            this.period = period;
            return this;
        }

        Training build() {
            // additional validation if needed
            return new Training(this);
        }
    }
}
