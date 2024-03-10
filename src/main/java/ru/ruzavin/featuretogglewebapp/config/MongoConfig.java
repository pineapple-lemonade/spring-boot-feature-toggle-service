package ru.ruzavin.featuretogglewebapp.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ru.ruzavin.featuretogglewebapp.config.properties.MongoProperties;

@Configuration
@EnableMongoRepositories(basePackages = "ru.ruzavin.featuretogglewebapp.repository")
@EnableConfigurationProperties(MongoProperties.class)
@RequiredArgsConstructor
public class MongoConfig {

    private final MongoProperties mongoProperties;

//    @Bean
//    public MongoClient mongo() {
//        ConnectionString connectionString = new ConnectionString(mongoProperties.uri());
//        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .build();
//
//        return MongoClients.create(mongoClientSettings);
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception {
//        return new MongoTemplate(mongo(), mongoProperties.database());
//    }

}
