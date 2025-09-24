package com.smalaca.opentrainingsale.domain.training;

import java.time.LocalDate;

public final class Period {
    private final LocalDate start;
    private final LocalDate end;

    private Period(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public static Period from(LocalDate startDate, LocalDate endDate) {
        if (LocalDate.now().isAfter(startDate)) {
            throw PeriodException.startInPast(startDate);
        }

        if (startDate.isAfter(endDate)) {
            throw PeriodException.endsBeforeStarts(startDate, endDate);
        }

        return new Period(startDate, endDate);
    }
}
