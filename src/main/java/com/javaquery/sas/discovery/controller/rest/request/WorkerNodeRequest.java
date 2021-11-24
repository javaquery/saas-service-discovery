package com.javaquery.sas.discovery.controller.rest.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * @author vicky.thakor
 * @since 1.0.0
 */
@NoArgsConstructor
@Getter
@Setter
public class WorkerNodeRequest {
    /**
     * When you have multiple teams and product you need to specify the ownership
     */
    @NotBlank
    private String owner;
    /**
     * service serving for tier like free, professional, enterprise, etc...
     */
    @NotBlank
    private String tier;
    /**
     * used to store tenantId, userId in case of saas product
     */
    @NotBlank
    private String identity;
    /**
     * type could service name like queue, topic, etc...
     */
    @NotBlank
    private String type;
    /**
     * environment of node like development, staging, production, etc...
     */
    @NotBlank
    private String environment;
    /**
     * destination could be queue or topic name
     */
    @NotBlank
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
