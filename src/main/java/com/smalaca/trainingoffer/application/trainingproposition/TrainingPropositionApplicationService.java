package com.smalaca.trainingoffer.application.trainingproposition;

import com.smalaca.trainingoffer.domain.trainingcatalogue.TrainingCatalogue;
import com.smalaca.trainingoffer.domain.trainingproposition.TrainingProposition;
import com.smalaca.trainingoffer.domain.trainingproposition.TrainingPropositionDto;
import com.smalaca.trainingoffer.domain.trainingproposition.TrainingPropositionFactory;
import com.smalaca.trainingoffer.domain.trainingproposition.TrainingPropositionRepository;
import com.smalaca.trainingoffer.domain.trainingtemplate.TrainingTemplate;
import com.smalaca.trainingoffer.domain.trainingtemplate.TrainingTemplateRepository;
import jakarta.transaction.Transactional;

import java.util.UUID;

public class TrainingPropositionApplicationService {
    private final TrainingPropositionRepository trainingPropositionRepository;
    private final TrainingTemplateRepository trainingTemplateRepository;
    private final TrainingCatalogue trainingCatalogue;

    public TrainingPropositionApplicationService(TrainingPropositionRepository trainingPropositionRepository, TrainingTemplateRepository trainingTemplateRepository, TrainingCatalogue trainingCatalogue) {
        this.trainingPropositionRepository = trainingPropositionRepository;
        this.trainingTemplateRepository = trainingTemplateRepository;
        this.trainingCatalogue = trainingCatalogue;
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

    @Transactional
    public void accept(UUID trainingPropositionId, UUID reviewerId) {
        TrainingProposition trainingProposition = trainingPropositionRepository.findById(trainingPropositionId);

        // interakcja z domeną - 1 linia kodu
        TrainingTemplate trainingTemplate = trainingProposition.accept(reviewerId, trainingCatalogue);

        trainingPropositionRepository.save(trainingProposition);
        trainingTemplateRepository.save(trainingTemplate);
    }
}
