package com.smalaca.trainingoffer.application.trainingtemplate;

import com.smalaca.trainingoffer.domain.trainingtemplate.Price;
import com.smalaca.trainingoffer.domain.trainingtemplate.TrainingTemplate;
import com.smalaca.trainingoffer.domain.trainingtemplate.TrainingTemplateRepository;
import jakarta.transaction.Transactional;

import java.util.UUID;

public class TrainingTemplateApplicationService {
    private final TrainingTemplateRepository trainingTemplateRepository;

    public TrainingTemplateApplicationService(TrainingTemplateRepository trainingTemplateRepository) {
        this.trainingTemplateRepository = trainingTemplateRepository;
    }

    @Transactional
    public void update(UpdateTrainingTemplateDto dto) {
        TrainingTemplate trainingTemplate = trainingTemplateRepository.findById(dto.trainingTemplateId());
        Price price = Price.from(dto.price());

        trainingTemplate.update(price, dto.trainingDays());

        trainingTemplateRepository.save(trainingTemplate);
    }

    @Transactional
    public void askToVerify(UUID trainingTemplateId) {
        // tłumaczenie na język domenowy [0..*]
        // id na aggregaty
        // typy proste na value objects
//        TrainingTemplateId trainingTemplateIdVO = new TrainingTemplateId(trainingTemplateId);
        TrainingTemplate trainingTemplate = trainingTemplateRepository.findById(trainingTemplateId);

        // interakcja z domeną - 1 linia kodu
        trainingTemplate.readyForReview();

        // zapis agregatów lub publikowanie zdarzeń [1..*]
        trainingTemplateRepository.save(trainingTemplate);
    }
}
