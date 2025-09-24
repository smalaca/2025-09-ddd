package com.smalaca.opentrainingsale.application.training;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record TrainingDto(
        UUID trainerId,
        String trainingCode,
        BigDecimal price,
        LocalDate startDate, LocalDate endDate,
        int minimumParticipants,
        int maximumParticipants) {
}
