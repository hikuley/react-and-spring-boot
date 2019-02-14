package com.settle.go.model;

public class RateRequest {

    private String sourceCurrency;

    private String buyCurrency;

    public RateRequest() {

    }

    public RateRequest(String sourceCurrency, String buyCurrency) {
        this.sourceCurrency = sourceCurrency;
        this.buyCurrency = buyCurrency;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getBuyCurrency() {
        return buyCurrency;
    }

    public void setBuyCurrency(String buyCurrency) {
        this.buyCurrency = buyCurrency;
    }
}
