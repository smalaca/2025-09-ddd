package com.smalaca.opentrainingsale.domain.training;

import java.util.UUID;

public interface TrainingRepository {
    void save(Training training);

    Training findById(UUID trainingId);
}
