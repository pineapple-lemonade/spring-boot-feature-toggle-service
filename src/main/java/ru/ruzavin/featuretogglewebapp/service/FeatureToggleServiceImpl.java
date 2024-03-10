package ru.ruzavin.featuretogglewebapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.ruzavin.featuretogglewebapp.entity.FeatureToggleEntity;
import ru.ruzavin.featuretogglewebapp.exception.DataNotFoundException;
import ru.ruzavin.featuretogglewebapp.repository.FeatureToggleRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FeatureToggleServiceImpl implements FeatureToggleService {

    private final FeatureToggleRepository featureToggleRepository;

    @Override
    @CacheEvict(key = "#value.id", cacheNames = "toggle")
    public UUID insertToggle(FeatureToggleEntity value) {
        FeatureToggleEntity entity = featureToggleRepository.insert(value);

        return entity.getId();
    }

    @Override
    @Cacheable(key = "#id", cacheNames = "toggle", condition = "#featureToggleRepository.findById(id).present")
    public FeatureToggleEntity getToggle(UUID id) {
        Optional<FeatureToggleEntity> optionalEntity = featureToggleRepository.findById(id);
        if (optionalEntity.isEmpty()) {
            throw new DataNotFoundException("Toggle with id " + id + " not found");
        }

        return optionalEntity.get();
    }

    @Override
    @Cacheable("toggles")
    public List<FeatureToggleEntity> findAll() {
        return featureToggleRepository.findAll();
    }

}
