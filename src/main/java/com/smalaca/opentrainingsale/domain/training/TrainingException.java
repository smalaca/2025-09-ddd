package com.smalaca.opentrainingsale.domain.training;

class TrainingException extends RuntimeException {
    private TrainingException(String message) {
        super(message);
    }

    static TrainingException tooLongTraining(Period period) {
        return new TrainingException("Training can take max 5 days. Start date: " + period.startDate() + ", end date: " + period.endDate());
    }

    static TrainingException tooFewMinimumParticipants(int minimumParticipants) {
        return new TrainingException("Minimum participants must be at least 5. Value: " + minimumParticipants);
    }

    static TrainingException tooManyMaximumParticipants(int maximumParticipants) {
        return new TrainingException("Maximum participants must be less than 30. Value: " + maximumParticipants);
    }

    static TrainingException invalidParticipantsNumber(int minimumParticipants, int maximumParticipants) {
        return new TrainingException("Minimum participants must be less than maximum participants. Minimum: " + minimumParticipants + ", maximum: " + maximumParticipants);
    }

    static TrainingException notExistingTrainingCode(TrainingCode trainingCode) {
        return new TrainingException("Training with code: " + trainingCode + " not found");
    }
}
