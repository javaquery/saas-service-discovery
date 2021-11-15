package com.javaquery.sas.discovery.controller.rest.exception;

/**
 * @author vicky.thakor
 * @since 1.0.0
 */
public class EntityNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(Class<?> entityClass, Object id) {
        super(String.format("%s was not found for parameter %s", entityClass.getSimpleName(), id));
    }
}
