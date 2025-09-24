package com.smalaca.opentrainingsale.domain.trainerscatalogue;

import java.time.LocalDate;
import java.util.UUID;

public record TrainingRequestDto(UUID trainerId, String trainingCode, LocalDate startDate, LocalDate endDate) {
}
