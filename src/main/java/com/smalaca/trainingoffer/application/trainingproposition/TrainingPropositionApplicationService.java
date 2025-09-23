package com.smalaca.trainingoffer.application.trainingproposition;

import com.smalaca.trainingoffer.domain.trainingproposition.TrainingProposition;
import com.smalaca.trainingoffer.domain.trainingproposition.TrainingPropositionDto;
import com.smalaca.trainingoffer.domain.trainingproposition.TrainingPropositionFactory;
import com.smalaca.trainingoffer.domain.trainingproposition.TrainingPropositionRepository;
import jakarta.transaction.Transactional;

public class TrainingPropositionApplicationService {
    private final TrainingPropositionRepository trainingPropositionRepository;

    public TrainingPropositionApplicationService(TrainingPropositionRepository trainingPropositionRepository) {
        this.trainingPropositionRepository = trainingPropositionRepository;
    }

    @Transactional
    public void proposeTraining(TrainingPropositionDto dto) {
        // tłumaczenie na język domenowy [0..*]
        // id na aggregaty
        // typy proste na value objects

        // interakcja z domeną - 1 linia kodu
        TrainingProposition trainingProposition = new TrainingPropositionFactory().create(dto);
// Other possible options:
//        TrainingProposition trainingProposition = new TrainingPropositionBuilder().title().description().build();
//        TrainingProposition trainingProposition = TrainingProposition.create(dto);

        // zapis agregatów lub publikowanie zdarzeń [1..*]
        trainingPropositionRepository.save(trainingProposition);
    }
}
