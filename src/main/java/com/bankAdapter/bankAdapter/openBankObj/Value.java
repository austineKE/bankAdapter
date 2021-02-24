package com.bankAdapter.bankAdapter.openBankObj;

/**
 * this the the value object
 * holds currency and amount
 */
public class Value {
    private String currency;
    private Double amount;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
