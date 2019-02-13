package com.settle.go.model;


public class TransactionCreateRequest {

    private Double sellAmount;
    private String sellCurrency;

    private String buyCurrency;
    private Double rate;


    public Double getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(Double sellAmount) {
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
