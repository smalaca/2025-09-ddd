package com.smalaca.trainingoffer.application.trainingproposition;

import com.smalaca.trainingoffer.domain.trainingproposition.TrainingProposition;
import com.smalaca.trainingoffer.domain.trainingproposition.TrainingPropositionRepository;
import jakarta.transaction.Transactional;

import java.util.UUID;

public class TrainingPropositionApplicationService {
    private final TrainingPropositionRepository trainingPropositionRepository;

    public TrainingPropositionApplicationService(TrainingPropositionRepository trainingPropositionRepository) {
        this.trainingPropositionRepository = trainingPropositionRepository;
    }

    @Transactional
    public void proposeTraining(UUID trainerId, String title, String description) {
        // tłumaczenie na język domenowy [0..*]
        // id na aggregaty
        // typy proste na value objects

        // interakcja z domeną - 1 linia kodu
        TrainingProposition trainingProposition = new TrainingProposition(trainerId, title, description);

        // zapis agregatów lub publikowanie zdarzeń [1..*]
        trainingPropositionRepository.save(trainingProposition);
    }
}
