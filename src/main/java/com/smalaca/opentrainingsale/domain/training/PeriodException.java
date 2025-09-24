package com.smalaca.opentrainingsale.domain.training;

import java.time.LocalDate;

class PeriodException extends RuntimeException {
    private PeriodException(String message) {
        super(message);
    }

    static PeriodException startInPast(LocalDate startDate) {
        return new PeriodException("Start date is from past: " + startDate);
    }

    static PeriodException endsBeforeStarts(LocalDate startDate, LocalDate endDate) {
        return new PeriodException("End date is before start date: " + startDate + " - " + endDate);
    }
}
