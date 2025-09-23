package com.smalaca.opentrainingsale.domain.training;

public record TrainingDomainDto(
        TrainingCode trainingCode, Price price, Period period, int minimumParticipants, int maximumParticipants) {
}
