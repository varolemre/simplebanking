package com.eteration.simplebanking.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
public class BillPaymentTransaction extends Transaction {

    public String payee;

    public BillPaymentTransaction() {
    }

    public BillPaymentTransaction(double a) {
        super(a);
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }
}