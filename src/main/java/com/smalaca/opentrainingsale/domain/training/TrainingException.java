package com.smalaca.opentrainingsale.domain.training;

class TrainingException extends RuntimeException {
    private TrainingException(String message) {
        super(message);
    }

    static TrainingException tooLongTraining(Period period) {
        return new TrainingException("Training can take max 5 days. Start date: " + period.startDate() + ", end date: " + period.endDate());
    }
}
