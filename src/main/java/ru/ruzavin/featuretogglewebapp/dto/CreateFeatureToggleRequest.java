package ru.ruzavin.featuretogglewebapp.dto;

import java.util.UUID;

public record CreateFeatureToggleRequest(
        UUID id,
        String name,
        Boolean active
) {
}
