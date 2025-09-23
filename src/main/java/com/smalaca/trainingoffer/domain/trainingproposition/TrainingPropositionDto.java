package com.smalaca.trainingoffer.domain.trainingproposition;

import org.springframework.validation.annotation.Validated;

import java.util.UUID;

public record TrainingPropositionDto(
        UUID trainerId,
        @Validated String title,
        @Validated String description) {
}
