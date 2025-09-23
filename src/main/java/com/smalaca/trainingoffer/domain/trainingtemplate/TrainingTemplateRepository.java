package com.smalaca.trainingoffer.domain.trainingtemplate;

import java.util.UUID;

// repository
public interface TrainingTemplateRepository {
    TrainingTemplate findById(UUID trainingTemplateId);

    void save(TrainingTemplate trainingTemplate);
}
