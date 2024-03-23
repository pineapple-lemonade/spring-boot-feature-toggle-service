package ru.ruzavin.featuretogglewebapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ruzavin.featuretogglewebapp.dto.CreateFeatureToggleRequest;
import ru.ruzavin.featuretogglewebapp.dto.FeatureToggleModel;
import ru.ruzavin.featuretogglewebapp.entity.FeatureToggleEntity;
import ru.ruzavin.featuretogglewebapp.mapper.FeatureToggleMapper;
import ru.ruzavin.featuretogglewebapp.service.FeatureToggleService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class FeatureToggleDataController {

    private final FeatureToggleService featureToggleService;

    private final FeatureToggleMapper featureToggleMapper;

    @GetMapping("/{id}")
    public FeatureToggleModel getFeatureToggle(@PathVariable UUID id) {
        return featureToggleMapper.fromEntity(featureToggleService.getToggle(id));
    }

    @PostMapping
    public FeatureToggleModel insertFeatureToggleService(@RequestBody CreateFeatureToggleRequest request) {
        return featureToggleMapper.fromEntity(featureToggleService.insertToggle(featureToggleMapper.fromRequest(request)));
    }

    @GetMapping
    public List<FeatureToggleModel> getFeatureToggles() {
        return featureToggleMapper.fromEntities(featureToggleService.findAll());
    }
}
