package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String owner;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountNumberGenerator")
    @SequenceGenerator(name = "accountNumberGenerator", sequenceName = "accountNumber_seq", initialValue = 1000)
    @Column(name = "accountNumber", updatable = false, nullable = false, unique = true)
    private String accountNumber;

    private double balance;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Transaction> transactions = new ArrayList<>();

    public Account(String owner, String accountNumber) {

        this.owner = owner;
        this.accountNumber = accountNumber;

    }

    public Account(){

    }

    public void post(Transaction transaction) throws InsufficientBalanceException {
        if ("WithdrawalTransaction".equals(transaction.getType())) {
            if (this.balance < transaction.amount) {
                throw new InsufficientBalanceException();
            } else {
                this.balance -= transaction.amount;
                transactions.add(transaction);
            }
        }

        if ("DepositTransaction".equals(transaction.getType())) {
            this.balance += transaction.amount;
            transactions.add(transaction);
        }

    }

    public double deposit(double credit) {
        this.balance += credit;
        return credit;
    }

    public double withdraw(double debit) throws InsufficientBalanceException {

        if (this.balance < debit) {

            throw new InsufficientBalanceException();
        } else
            this.balance -= debit;

        return debit;
    }


}
