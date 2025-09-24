package com.smalaca.opentrainingsale.domain.training;

import java.util.UUID;

public record TrainingDomainDto(
        UUID trainerId, TrainingCode trainingCode, Price price, Period period, int minimumParticipants, int maximumParticipants) {
}
