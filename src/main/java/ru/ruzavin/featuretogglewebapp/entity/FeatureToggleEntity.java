package ru.ruzavin.featuretogglewebapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Document(collation = "feature_toggle")
public class FeatureToggleEntity {

    @Id
    private UUID id;

    private String name;

    private Boolean toggle;
}
