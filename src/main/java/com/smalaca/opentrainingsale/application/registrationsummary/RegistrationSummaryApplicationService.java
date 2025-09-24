package com.smalaca.opentrainingsale.application.registrationsummary;

import com.smalaca.opentrainingsale.domain.registrationsummary.RegistrationSummary;
import com.smalaca.opentrainingsale.domain.registrationsummary.RegistrationSummaryRepository;
import com.smalaca.opentrainingsale.domain.sale.Sale;
import com.smalaca.opentrainingsale.domain.sale.SaleRepository;
import com.smalaca.opentrainingsale.domain.training.Training;
import com.smalaca.opentrainingsale.domain.training.TrainingRepository;

import java.util.UUID;

public class RegistrationSummaryApplicationService {
    private final RegistrationSummaryRepository registrationSummaryRepository;
    private final SaleRepository saleRepository;
    private final TrainingRepository trainingRepository;

    public RegistrationSummaryApplicationService(RegistrationSummaryRepository registrationSummaryRepository, SaleRepository saleRepository, TrainingRepository trainingRepository) {
        this.registrationSummaryRepository = registrationSummaryRepository;
        this.saleRepository = saleRepository;
        this.trainingRepository = trainingRepository;
    }

    public void confirm(UUID registrationSummaryId) {
        RegistrationSummary registrationSummary = registrationSummaryRepository.findById(registrationSummaryId);
        Training training = trainingRepository.findById(registrationSummary.trainingId());

        Sale sale = registrationSummary.confirm();
        training.confirmAttendance(registrationSummary.participantId());

        registrationSummaryRepository.save(registrationSummary);
        saleRepository.save(sale);
        trainingRepository.save(training);
    }
}
