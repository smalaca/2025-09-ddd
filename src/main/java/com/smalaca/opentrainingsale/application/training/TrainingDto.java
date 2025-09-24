package com.smalaca.opentrainingsale.application.training;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TrainingDto(
        String trainingCode,
        BigDecimal price,
        LocalDate startDate, LocalDate endDate,
        int minimumParticipants,
        int maximumParticipants) {
}
