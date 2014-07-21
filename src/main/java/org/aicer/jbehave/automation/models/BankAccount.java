package org.aicer.jbehave.automation.models;

public class BankAccount {

    private double balance;

    public BankAccount() {
        this.balance = 0.00;
    }

    public BankAccount setBalance(final double amount) {
        this.balance = amount;
        return this;
    }

    public double getBalance() {
        return this.balance;
    }

    public BankAccount withdraw(final double amount) {
        this.balance = this.balance - amount;
        return this;
    }

    public BankAccount deposit(final double amount) {
        this.balance = this.balance + amount;
        return this;
    }

    public boolean isAbleToDeposit() {
        return true;
    }

    public boolean isAbleToWithdraw() {
        return this.balance > 0.00;
    }
}
