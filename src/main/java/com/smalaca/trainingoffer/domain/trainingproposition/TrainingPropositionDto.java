package com.smalaca.trainingoffer.domain.trainingproposition;

import org.springframework.validation.annotation.Validated;

import java.util.UUID;

public record TrainingPropositionDto(
        String trainerCode,
        @Validated String title,
        @Validated String description) {
}
