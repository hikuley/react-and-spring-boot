package com.settle.go.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {

    public static final class Builder {

        private String id;
        private Long timestamp;
        private boolean success = true;
        private String responseCode;
        private String responseMessage;
        private Object data;
        private Long totalCount;

        public Builder() {
        }

        public BaseResponse build() {

            BaseResponse response = new BaseResponse();

            response.id = this.id;
            response.timestamp = this.timestamp;
            response.success = this.success;
            response.responseCode = this.responseCode;
            response.responseMessage = this.responseMessage;
            response.data = this.data;
            response.totalCount = this.totalCount;
            return response;
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withResponseCode(String responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        public Builder withResponseMessage(String responseMessage) {
            this.responseMessage = responseMessage;
            return this;
        }

        public Builder withSuccess(boolean success) {
            this.success = success;
            return this;
        }

        public Builder withTimestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder withData(Object data) {
            this.data = data;
            return this;
        }

        public Builder withTotalCount(Long totalCount) {
            this.totalCount = totalCount;
            return this;
        }


    }

    @NotNull
    private String id;

    @NotNull
    private Long timestamp;

    private boolean success = true;

    private String responseCode;

    private String responseMessage;

    private Object data;

    private Long totalCount;

    public BaseResponse() {
        this.timestamp = System.currentTimeMillis();
    }

    public BaseResponse(String id, boolean success) {
        this.id = id;
        this.success = success;
        this.timestamp = System.currentTimeMillis();
    }

    public BaseResponse(String id, boolean success, String responseCode) {
        this.id = id;
        this.success = success;
        this.responseCode = responseCode;
        this.timestamp = System.currentTimeMillis();
    }

    public BaseResponse(String id, boolean success, String responseCode, String responseMessage) {
        this.id = id;
        this.success = success;
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.timestamp = System.currentTimeMillis();
    }


    public String getId() {
        return id;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BaseResponse.class.getSimpleName() + "[", "]").add("id='" + id + "'")
                .add("success=" + success).add("responseCode='" + responseCode + "'")
                .add("responseMessage='" + responseMessage + "'").toString();
    }

}