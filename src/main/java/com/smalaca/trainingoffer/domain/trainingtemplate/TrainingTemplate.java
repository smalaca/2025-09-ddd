package com.smalaca.trainingoffer.domain.trainingtemplate;

import java.util.UUID;

// aggregate root
public class TrainingTemplate {
    private final UUID trainingPropositionId;
    private final TrainingTemplateCode trainingTemplateCode;
    private final String title;
    private final String description;
    private final String trainerCode;
    private UUID trainingTemplateId;
    private Price price;
    private int trainingDays;

    private TrainingTemplate(
            UUID trainingPropositionId, TrainingTemplateCode trainingTemplateCode, String title, String description, String trainerCode) {
        this.trainingPropositionId = trainingPropositionId;
        this.trainingTemplateCode = trainingTemplateCode;
        this.title = title;
        this.description = description;
        this.trainerCode = trainerCode;
    }

    // factory
    public static TrainingTemplate create(UUID trainingPropositionId, String title, String description, String trainerCode) {
        TrainingTemplateCode trainingTemplateCode = TrainingTemplateCode.from(trainerCode);
        return new TrainingTemplate(trainingPropositionId, trainingTemplateCode, title, description, trainerCode);
    }

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
