package ru.ruzavin.featuretogglewebapp.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import ru.ruzavin.featuretogglewebapp.entity.FeatureToggleEntity;

@Repository
@RequiredArgsConstructor
public class CustomFeatureToggleRepositoryImpl implements CustomFeatureToggleRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public FeatureToggleEntity upsertByName(FeatureToggleEntity entity) {
        Query query = new Query(Criteria.where("name").is(entity.getName()));
        Update update = new Update()
                .set("active", entity.getActive())
                .set("name", entity.getName());

        return mongoTemplate.findAndModify(
                query,
                update,
                org.springframework.data.mongodb.core.FindAndModifyOptions.options().upsert(true).returnNew(true),
                FeatureToggleEntity.class
        );
    }
}
