package com.smalaca.trainingoffer.domain.training;

import java.util.UUID;

public interface TrainingRepository {
    Training findById(UUID trainingId);

    void save(Training training);
}
