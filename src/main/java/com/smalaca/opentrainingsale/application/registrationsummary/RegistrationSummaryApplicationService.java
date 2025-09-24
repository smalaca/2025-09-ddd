package com.smalaca.opentrainingsale.application.registrationsummary;

import com.smalaca.opentrainingsale.domain.registrationconfirmation.RegistrationSummaryConfirmationDomainService;
import com.smalaca.opentrainingsale.domain.registrationconfirmation.RegistrationSummaryConfirmedDto;
import com.smalaca.opentrainingsale.domain.registrationsummary.RegistrationSummary;
import com.smalaca.opentrainingsale.domain.registrationsummary.RegistrationSummaryRepository;
import com.smalaca.opentrainingsale.domain.sale.SaleRepository;
import com.smalaca.opentrainingsale.domain.training.Training;
import com.smalaca.opentrainingsale.domain.training.TrainingRepository;

import java.util.UUID;

public class RegistrationSummaryApplicationService {
    private final RegistrationSummaryRepository registrationSummaryRepository;
    private final SaleRepository saleRepository;
    private final TrainingRepository trainingRepository;
    private final RegistrationSummaryConfirmationDomainService registrationSummaryConfirmationDomainService;

    public RegistrationSummaryApplicationService(RegistrationSummaryRepository registrationSummaryRepository, SaleRepository saleRepository, TrainingRepository trainingRepository, RegistrationSummaryConfirmationDomainService registrationSummaryConfirmationDomainService) {
        this.registrationSummaryRepository = registrationSummaryRepository;
        this.saleRepository = saleRepository;
        this.trainingRepository = trainingRepository;
        this.registrationSummaryConfirmationDomainService = registrationSummaryConfirmationDomainService;
    }

    public void confirm(UUID registrationSummaryId) {
        RegistrationSummary registrationSummary = registrationSummaryRepository.findById(registrationSummaryId);
        Training training = trainingRepository.findById(registrationSummary.trainingId());

        RegistrationSummaryConfirmedDto dto = registrationSummaryConfirmationDomainService.confirm(registrationSummary, training);

        registrationSummaryRepository.save(dto.registrationSummary());
        saleRepository.save(dto.sale());
        trainingRepository.save(dto.training());
    }
}
