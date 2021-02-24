package com.bankAdapter.bankAdapter.openBankObj;

/**
 * This the details object.
 * holds value object, transaction type and description
 */
public class Details {
    private String type;
    private String description;
    private Value value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
