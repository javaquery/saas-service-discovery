package com.javaquery.sas.discovery.controller.rest.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author vicky.thakor
 * @since 1.0.0
 */
@NoArgsConstructor
@Getter
@Setter
public class WorkerNodeFindRequest {
    private String owner;
    private String tier;
    private String identity;
    private String type;
    private String environment;
    private String destination;
    private Boolean active = true;
}
