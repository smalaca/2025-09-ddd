package com.smalaca.trainingoffer.domain.trainingtemplate;

import java.util.UUID;

class TrainingTemplateException extends RuntimeException {
    private TrainingTemplateException(String message) {
        super(message);
    }

    static RuntimeException incorrectTrainingDays(UUID trainingTemplateId, int trainingDays) {
        return new TrainingTemplateException("Incorrect training days: " + trainingDays + " for TrainingTemplate: " + trainingTemplateId);
    }
}
