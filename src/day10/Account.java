package day10;

public class Account {
    private final String id;
    private final String name;
    private String pin;
    private double balance;
    private String[] transactions;
    private int txnCount;

    public Account(String id, String name,  String pin, double initialBalance) {
        this.id = id;
        this.name = name;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactions = new String[10];
        this.txnCount = 0;
        addTransaction("Account created. Balance: " + balance);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public boolean checkPin(String p){ return this.pin.equals(p); }
    public double getBalance() { return balance; }

    public void deposit(double amt){
        if(amt<=0){
            addTransaction("Invalid deposit: " + amt);
            return;
        }
        balance += amt;
        addTransaction("Deposit: " + amt + " New balance: " + balance);
    }

    public boolean withdraw(double amt){
        if(amt<=0){
            addTransaction("Invalid withdraw: " + amt);
            return false;
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
        if (txnCount >= transactions.length) {
            String[] temp = new String[transactions.length * 2];
            for(int i=0; i<transactions.length; i++) temp[i] = transactions[i];
            transactions = temp;
        }
        transactions[txnCount++] = entry;
    }

    public String[] getTransactions() {
        String[] out = new String[txnCount];
        for(int i=0; i<txnCount; i++) out[i] = transactions[i];
        return out;
    }

}
