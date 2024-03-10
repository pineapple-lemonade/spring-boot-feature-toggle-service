package ru.ruzavin.featuretogglewebapp.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.data.mongodb")
public record MongoProperties(
        String uri,
        String database
) {

}
