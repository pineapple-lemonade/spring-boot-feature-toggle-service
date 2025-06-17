package ru.ruzavin.featuretogglewebapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.ruzavin.featuretogglewebapp.entity.FeatureToggleEntity;

import java.util.Optional;
import java.util.UUID;

public interface FeatureToggleRepository extends MongoRepository<FeatureToggleEntity, UUID>, CustomFeatureToggleRepository {

    Optional<FeatureToggleEntity> findByName(String name);

}
