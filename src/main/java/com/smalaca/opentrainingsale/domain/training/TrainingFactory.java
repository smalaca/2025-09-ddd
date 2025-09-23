package com.smalaca.opentrainingsale.domain.training;

// factory
public class TrainingFactory {
    public Training create(TrainingDomainDto dto) {
        return new Training(dto.trainingCode(), dto.price(), dto.period());
    }
}
