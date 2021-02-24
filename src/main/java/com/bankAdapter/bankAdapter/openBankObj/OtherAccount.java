package com.bankAdapter.bankAdapter.openBankObj;

/**
 * this is the other account object
 * holds account number, metadata and holder details
 */
public class OtherAccount {
    private String number;
    private Metadata metadata;
    private Holder holder;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }
}
