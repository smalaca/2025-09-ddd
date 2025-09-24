package com.smalaca.trainingoffer.domain.trainingtemplate;

import java.util.UUID;

// value object
class TrainingTemplateCode {
    private final String trainingTemplateCode;

    private TrainingTemplateCode(String trainingTemplateCode) {
        this.trainingTemplateCode = trainingTemplateCode;
    }

    // factory
    static TrainingTemplateCode from(String trainerCode) {
        return new TrainingTemplateCode(trainerCode + "/SZS/" + UUID.randomUUID());
    }
}
