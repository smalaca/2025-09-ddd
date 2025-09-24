package com.smalaca.opentrainingsale.domain.training;

import com.smalaca.opentrainingsale.domain.price.Price;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Training {
    private final TrainingCode trainingCode;
    private final Price price;
    private final Period period;
    private final int minimumParticipants;
    private final int maximumParticipants;
    private final List<UUID> participants = new ArrayList<>();

    private Training(TrainingBuilder builder) {
        this.trainingCode = builder.trainingCode;
        this.price = builder.price;
        this.period = builder.period;
        this.minimumParticipants = builder.minimumParticipants;
        this.maximumParticipants = builder.maximumParticipants;
    }

    public void confirmAttendance(UUID participantId) {
        if (participants.size() >= maximumParticipants) {
            throw TrainingException.maximumGroupSizeReached(maximumParticipants, participantId);
        }

        participants.add(participantId);
    }

    // factory
    static class TrainingBuilder {
        private TrainingCode trainingCode;
        private Price price;
        private Period period;
        private int minimumParticipants;
        private int maximumParticipants;

        Training build() {
            if (minimumParticipants < 5) {
                throw TrainingException.tooFewMinimumParticipants(minimumParticipants);
            }

            if (maximumParticipants > 30) {
                throw TrainingException.tooManyMaximumParticipants(maximumParticipants);
            }

            if (minimumParticipants > maximumParticipants) {
                throw TrainingException.invalidParticipantsNumber(minimumParticipants, maximumParticipants);
            }

            if (ChronoUnit.DAYS.between(period.startDate(), period.endDate()) > 5) {
                throw TrainingException.tooLongTraining(period);
            }

            return new Training(this);
        }

        TrainingBuilder trainingCode(TrainingCode trainingCode) {
            this.trainingCode = trainingCode;
            return this;
        }

        TrainingBuilder price(Price price) {
            this.price = price;
            return this;
        }

        TrainingBuilder period(Period period) {
            this.period = period;
            return this;
        }

        TrainingBuilder minimumParticipants(int minimumParticipants) {
            this.minimumParticipants = minimumParticipants;
            return this;
        }

        TrainingBuilder maximumParticipants(int maximumParticipants) {
            this.maximumParticipants = maximumParticipants;
            return this;
        }
    }
}
