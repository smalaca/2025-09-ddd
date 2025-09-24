package com.smalaca.opentrainingsale.domain.registrationsummary;

import java.util.UUID;

public interface RegistrationSummaryRepository {
    RegistrationSummary findById(UUID registrationSummaryId);

    void save(RegistrationSummary registrationSummary);
}

