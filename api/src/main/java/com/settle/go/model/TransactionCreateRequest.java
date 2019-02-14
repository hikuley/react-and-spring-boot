package com.settle.go.model;


import java.math.BigDecimal;

public class TransactionCreateRequest {

    private BigDecimal sellAmount;
    private String sellCurrency;

    private String buyCurrency;
    private BigDecimal rate;

    public TransactionCreateRequest() {

    }

    public TransactionCreateRequest(BigDecimal sellAmount, String sellCurrency, String buyCurrency, BigDecimal rate) {
        this.sellAmount = sellAmount;
        this.sellCurrency = sellCurrency;
        this.buyCurrency = buyCurrency;
        this.rate = rate;
    }

    public BigDecimal getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(BigDecimal sellAmount) {
        this.sellAmount = sellAmount;
    }

    public String getSellCurrency() {
        return sellCurrency.toUpperCase();
    }

    public void setSellCurrency(String sellCurrency) {
        this.sellCurrency = sellCurrency.toUpperCase();
    }

    public String getBuyCurrency() {
        return buyCurrency.toUpperCase();
    }

    public void setBuyCurrency(String buyCurrency) {
        this.buyCurrency = buyCurrency.toUpperCase();
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
