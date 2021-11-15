package com.javaquery.sas.discovery.controller.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author vicky.thakor
 * @since 1.0.0
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private String message;
    @JsonProperty("error_messages")
    private List<String> errorMessages;
    private int status;
    private T payload;

    private CommonResponse(T payload) {
        this.payload = payload;
    }

    public static <T> CommonResponse<T> of(T payload) {
        return CommonResponse.builder(payload).status(200).build();
    }

    public static <T> CommonResponse<Dummy> of(String message) {
        return CommonResponse.builder(new Dummy()).status(200).message(message).build();
    }

    public static <T> CommonResponse<T> of(T payload, String msg) {
        return CommonResponse.builder(payload).message(msg).status(200).build();
    }

    public static CommonResponse<Dummy> of(int status, List<String> errorMessages){
        return CommonResponse.builder(new Dummy()).status(status).errors(errorMessages).build();
    }

    public static <T> Builder<T> builder(T payload) {
        return new Builder<>(payload);
    }

    public static class Builder<T> {
        private final CommonResponse<T> response;

        public Builder(T payload) {
            response = new CommonResponse<>(payload);
        }

        public Builder<T> message(String message) {
            response.message = message;
            return this;
        }

        public Builder<T> status(int status) {
            response.status = status;
            return this;
        }

        public Builder<T> errors(List<String> errorMessages) {
            response.errorMessages = errorMessages;
            return this;
        }

        public Builder<T> payload(T payload) {
            response.payload = payload;
            return this;
        }

        public CommonResponse<T> build() {
            return response;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class Dummy implements Serializable{
        private String dummy;

        public String getDummy() {
            return dummy;
        }

        public void setDummy(String dummy) {
            this.dummy = dummy;
        }
    }
}