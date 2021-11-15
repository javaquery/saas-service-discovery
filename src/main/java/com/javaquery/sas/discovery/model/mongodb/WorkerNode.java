package com.javaquery.sas.discovery.model.mongodb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

/**
 * @author vicky.thakor
 * @since 1.0.0
 */
@Document(collection = "worker-nodes")
@CompoundIndex(name="unique-worker-node", unique = true, def = "{'identity':1, 'type':1, 'environment':1, 'destination':1}")
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WorkerNode {
    @Id
    private String id;
    /**
     * used to store tenantId, userId in case of saas product
     */
    private String identity;
    /**
     * type could service name like queue, topic, etc...
     */
    private String type;
    /**
     * environment of node like development, staging, production, etc...
     */
    private String environment;
    /**
     * destination could be queue or topic name
     */
    private String destination;
    /**
     * url of service
     */
    private String url;
    /**
     * token if any required
     */
    private String token;
    /**
     * username if any required
     */
    private String username;
    /**
     * password if any required
     */
    private String password;
    /**
     * other attributes used for service connection
     */
    private Map<String, Object> attributes;
}
