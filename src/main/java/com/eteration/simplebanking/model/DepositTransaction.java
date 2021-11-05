package com.eteration.simplebanking.model;


import javax.persistence.Entity;

@Entity
public class DepositTransaction extends Transaction  {

    public DepositTransaction() {

    }

    public DepositTransaction(double depositTransaction) {
        super(depositTransaction);
        this.setType("DepositTransaction");
    }

}
