package com.smalaca.trainingoffer.domain.trainingtemplate;

import java.util.UUID;

// aggregate root
public class TrainingTemplate {
    private UUID trainingTemplateId;
    private Price price;
    private int trainingDays;

    public void readyForReview() {

    }

    public void update(Price price, int trainingDays) {
        if (trainingDays < 1 || trainingDays > 5) {
            throw TrainingTemplateException.incorrectTrainingDays(trainingTemplateId, trainingDays);
        }

        this.trainingDays = trainingDays;
        this.price = price;
    }
}
