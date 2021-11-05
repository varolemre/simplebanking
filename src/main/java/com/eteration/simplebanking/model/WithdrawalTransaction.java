package com.eteration.simplebanking.model;


import javax.persistence.Entity;

// This class is a place holder you can change the complete implementation
@Entity
public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction() {

    }

    public WithdrawalTransaction(double withdrawalTransaction) {
        super(withdrawalTransaction);
        this.setType("WithdrawalTransaction");
    }
}



