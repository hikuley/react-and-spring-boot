package com.settle.go.model;

import java.util.HashMap;

public class RateQueryResponse {

    private boolean success;

    private String source;

    private HashMap<String, Double> quotes;

    private Error error;


    public RateQueryResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public HashMap<String, Double> getQuotes() {
        return quotes;
    }

    public void setQuotes(HashMap<String, Double> quotes) {
        this.quotes = quotes;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
