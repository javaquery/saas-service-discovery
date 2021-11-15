package com.javaquery.sas.discovery.service;

import com.javaquery.sas.discovery.controller.rest.exception.EntityNotFoundException;
import com.javaquery.sas.discovery.controller.rest.request.WorkerNodeFindRequest;
import com.javaquery.sas.discovery.controller.rest.request.WorkerNodeRequest;
import com.javaquery.sas.discovery.model.mongodb.WorkerNode;
import com.javaquery.sas.discovery.model.mongodb.repositories.WorkerNodeRepository;
import com.javaquery.util.string.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerNodeService {

    @Autowired
    private WorkerNodeRepository workerNodeRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<WorkerNode> findAllWorkerNodes() {
        return workerNodeRepository.findAll();
    }

    public List<WorkerNode> findWorkerNodes(WorkerNodeFindRequest request) {
        Query query = new Query();
        Strings.nonNullNonEmpty(request.getIdentity(), () -> query.addCriteria(Criteria.where("identity").is(request.getIdentity())));
        Strings.nonNullNonEmpty(request.getType(), () -> query.addCriteria(Criteria.where("type").is(request.getType())));
        Strings.nonNullNonEmpty(request.getEnvironment(), () -> query.addCriteria(Criteria.where("environment").is(request.getEnvironment())));
        Strings.nonNullNonEmpty(request.getDestination(), () -> query.addCriteria(Criteria.where("destination").is(request.getDestination())));
        return mongoTemplate.find(query, WorkerNode.class);
    }

    public WorkerNode save(WorkerNodeRequest request) {
        WorkerNode workerNode = new WorkerNode();
        workerNode.setIdentity(request.getIdentity());
        workerNode.setType(request.getType());
        workerNode.setEnvironment(request.getEnvironment());
        workerNode.setDestination(request.getDestination());
        workerNode.setUrl(request.getUrl());
        workerNode.setToken(request.getToken());
        workerNode.setUsername(request.getUsername());
        workerNode.setPassword(request.getPassword());
        workerNode.setAttributes(request.getAttributes());
        try {
            return workerNodeRepository.save(workerNode);
        }catch (DuplicateKeyException e){
            throw new RuntimeException("worker node already registered");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public WorkerNode update(String id, WorkerNodeRequest request) {
        try {
            Optional<WorkerNode> workerNode = workerNodeRepository.findById(id);
            if(workerNode.isPresent()){
                workerNode.get().setIdentity(request.getIdentity());
                workerNode.get().setType(request.getType());
                workerNode.get().setEnvironment(request.getEnvironment());
                workerNode.get().setDestination(request.getDestination());
                workerNode.get().setUrl(request.getUrl());
                workerNode.get().setToken(request.getToken());
                workerNode.get().setUsername(request.getUsername());
                workerNode.get().setPassword(request.getPassword());
                workerNode.get().setAttributes(request.getAttributes());
                return workerNodeRepository.save(workerNode.get());
            }else{
                throw new EntityNotFoundException(WorkerNode.class, id);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public WorkerNode delete(String id) {
        Optional<WorkerNode> workerNode = workerNodeRepository.findById(id);
        try{
            workerNodeRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return workerNode.get();
    }
}
