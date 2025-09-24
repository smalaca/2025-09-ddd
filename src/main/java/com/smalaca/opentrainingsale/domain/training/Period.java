package com.smalaca.opentrainingsale.domain.training;

import java.time.LocalDate;

// value object
public final class Period {
    private final LocalDate startDate;
    private final LocalDate endDate;

    private Period(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // factory
    public static Period from(LocalDate startDate, LocalDate endDate) {
        if (LocalDate.now().isAfter(startDate)) {
            throw PeriodException.startInPast(startDate);
        }

        if (startDate.isAfter(endDate)) {
            throw PeriodException.endsBeforeStarts(startDate, endDate);
        }

        return new Period(startDate, endDate);
    }

    LocalDate startDate() {
        return startDate;
    }

    LocalDate endDate() {
        return endDate;
    }
}
