package com.smalaca.trainingoffer.application.trainingtemplate;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdateTrainingTemplateDto(UUID trainingTemplateId, BigDecimal price, int trainingDays) {
}
