package day10;

import java.util.List;
import java.util.ArrayList;

public class Account {
    private final String id;
    private final String name;
    private final String pin;
    private double balance;
    private final List<String> transactions;

    public Account(String id, String name,  String pin, double initialBalance) {
        this.id = id;
        this.name = name;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        addTransaction("Account created. Balance: " + balance);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public boolean checkPin(String p){ return this.pin.equals(p); }
    public double getBalance() { return balance; }

    public void deposit(double amt) throws IllegalArgumentException {
        if(amt<=0){
            throw new IllegalArgumentException("Invalid amount.");
        }
        balance += amt;
        addTransaction("Deposit: " + amt + " New balance: " + balance);
    }

    public boolean withdraw(double amt) throws IllegalArgumentException {
        if(amt<=0){
            throw new IllegalArgumentException("Invalid amount.");
        }
        if(amt>balance){
            addTransaction("Transaction failed. Insufficient funds." + balance);
            return false;
        }
        balance -= amt;
        addTransaction("Withdraw: " + amt + " Remaining balance: " + balance);
        return true;
    }

    public void addTransaction(String entry) {
        transactions.add(entry);
    }

    public List<String> getTransactions() {
        return  new ArrayList<>(transactions); // return a safe copy
    }

}
