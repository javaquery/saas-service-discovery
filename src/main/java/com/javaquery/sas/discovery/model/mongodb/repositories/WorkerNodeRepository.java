package com.javaquery.sas.discovery.model.mongodb.repositories;

import com.javaquery.sas.discovery.model.mongodb.WorkerNode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vicky.thakor
 * @since 1.0.0
 */
@Repository
public interface WorkerNodeRepository extends MongoRepository<WorkerNode, String> {
}
