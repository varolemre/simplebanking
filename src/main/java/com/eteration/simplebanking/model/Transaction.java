package com.eteration.simplebanking.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public abstract class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;

    public double amount;

    @Column
    public String type;

    @Column
    public String approvalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    public Transaction(double transaction) {

        this.date = new Date();
        this.amount = transaction;

    }

    public Transaction() {

    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", approvalCode='" + approvalCode + '\'' +
                ", account=" + account +
                '}';
    }
}