package org.holo.repo;

import org.holo.entity.Rule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository extends MongoRepository<Rule, String> {
}
