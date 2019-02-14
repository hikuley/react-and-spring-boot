package com.settle.go.domain;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "Transaction")
public class TransactionEntity extends BaseEntity {

    private BigDecimal sellAmount;
    private String sellCurrency;

    private BigDecimal buyAmount;
    private String buyCurrency;


    public TransactionEntity() {


    }

    public TransactionEntity(BigDecimal sellAmount, String sellCurrency, BigDecimal buyAmount, String buyCurrency) {
        this.sellAmount = sellAmount;
        this.sellCurrency = sellCurrency;
        this.buyAmount = buyAmount;
        this.buyCurrency = buyCurrency;
    }

    public BigDecimal getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(BigDecimal sellAmount) {
        this.sellAmount = sellAmount;
    }

    public String getSellCurrency() {
        return sellCurrency;
    }

    public void setSellCurrency(String sellCurrency) {
        this.sellCurrency = sellCurrency;
    }

    public BigDecimal getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(BigDecimal buyAmount) {
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