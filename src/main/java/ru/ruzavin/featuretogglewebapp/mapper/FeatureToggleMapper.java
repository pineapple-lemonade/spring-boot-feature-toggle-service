package ru.ruzavin.featuretogglewebapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.ruzavin.featuretogglewebapp.dto.CreateFeatureToggleRequest;
import ru.ruzavin.featuretogglewebapp.dto.FeatureToggleModel;
import ru.ruzavin.featuretogglewebapp.entity.FeatureToggleEntity;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface FeatureToggleMapper {

    FeatureToggleModel fromEntity(FeatureToggleEntity featureToggleEntity);

    List<FeatureToggleModel> fromEntities(List<FeatureToggleEntity> entities);


    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    FeatureToggleEntity fromRequest(CreateFeatureToggleRequest request);
}
