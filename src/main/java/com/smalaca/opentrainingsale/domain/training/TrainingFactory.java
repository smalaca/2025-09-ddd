package com.smalaca.opentrainingsale.domain.training;

// factory
public class TrainingFactory {
    public Training create(TrainingDomainDto dto) {
        return new Training.TrainingBuilder()
                .trainingCode(dto.trainingCode())
                .price(dto.price())
                .period(dto.period())
                .minimumParticipants(dto.minimumParticipants())
                .maximumParticipants(dto.maximumParticipants())
                .build();
    }
}
