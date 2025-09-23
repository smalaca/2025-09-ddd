package com.smalaca.trainingoffer.application.trainingproposition;

import java.util.UUID;

public record TrainingPropositionDto(UUID trainerId, String title, String description) {
}
