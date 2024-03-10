package ru.ruzavin.featuretogglewebapp.service;

import ru.ruzavin.featuretogglewebapp.entity.FeatureToggleEntity;

import java.util.List;
import java.util.UUID;

public interface FeatureToggleService {

    UUID insertToggle(FeatureToggleEntity value);

    FeatureToggleEntity getToggle(UUID id);

    List<FeatureToggleEntity> findAll();
}
