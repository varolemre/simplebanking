package com.eteration.simplebanking.model;

import javax.persistence.Entity;

@Entity
public class CheckTransaction extends BillPaymentTransaction {

    public CheckTransaction() {
    }

    public CheckTransaction(double transaction) {
        this.type = "WithdrawalTransaction";
        this.amount = transaction;
    }

}

