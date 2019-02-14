package com.settle.go.model;

import java.math.BigDecimal;

public class Rate {

    private String currency;
    private BigDecimal rate;


    public Rate() {

    }

    public Rate(String currency, BigDecimal rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
