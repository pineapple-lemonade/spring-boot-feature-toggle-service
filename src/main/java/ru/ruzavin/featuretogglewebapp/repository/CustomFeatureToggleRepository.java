package ru.ruzavin.featuretogglewebapp.repository;

import ru.ruzavin.featuretogglewebapp.entity.FeatureToggleEntity;

public interface CustomFeatureToggleRepository {

    FeatureToggleEntity upsertByName(FeatureToggleEntity entity);

}
