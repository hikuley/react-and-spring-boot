package com.settle.go.domain;

import javax.persistence.Entity;
import java.util.Objects;

@Entity(name = "Transaction")
public class TransactionEntity extends BaseEntity {

    private Double sellAmount;
    private String sellCurrency;

    private Double buyAmount;
    private String buyCurrency;


    public TransactionEntity() {
    }


    public Double getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(Double sellAmount) {
        this.sellAmount = sellAmount;
    }

    public String getSellCurrency() {
        return sellCurrency;
    }

    public void setSellCurrency(String sellCurrency) {
        this.sellCurrency = sellCurrency;
    }

    public Double getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(Double buyAmount) {
        this.buyAmount = buyAmount;
    }

    public String getBuyCurrency() {
        return buyCurrency;
    }

    public void setBuyCurrency(String buyCurrency) {
        this.buyCurrency = buyCurrency;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntity that = (TransactionEntity) o;
        return sellAmount == that.sellAmount &&
                buyAmount == that.buyAmount &&
                Objects.equals(sellCurrency, that.sellCurrency) &&
                Objects.equals(buyCurrency, that.buyCurrency);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sellAmount, sellCurrency, buyAmount, buyCurrency);
    }
}