package ru.ruzavin.featuretogglewebapp.dto;

public record CreateFeatureToggleRequest(
        String name,
        Boolean active
) {
}
