package com.smalaca.trainingoffer.infrastructure.api.rest.trainingproposition;

import com.smalaca.trainingoffer.application.trainingproposition.TrainingPropositionApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingPropisitionRestController {
    private final TrainingPropositionApplicationService applicationService;

    public TrainingPropisitionRestController(TrainingPropositionApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public void proposeTraining(@RequestBody TrainingPropositionDto dto) {
        applicationService.proposeTraining();
    }
}
