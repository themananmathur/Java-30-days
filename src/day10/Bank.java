package day10;

public class Bank {
    private Account[] accounts;
    private int accountsCount;

    public Bank(int capacity){
        accounts = new Account[capacity];
        accountsCount = 0;
    }

    public void addAccount(Account a){
        if(accountsCount >= accounts.length){
            Account[] temp = new Account[accounts.length*2];
            for(int i=0; i<accounts.length; i++) temp[i] = accounts[i];
            accounts = temp;
        }
        accounts[accountsCount++] = a;
    }

    public Account findById(String id) {
        for (int i = 0; i < accountsCount; i++) {
            if (id.equals(accounts[i].getId())) return accounts[i];
        }
        return null;
    }

    public boolean transfer(Account from, String toId, double amt) {
        Account to = findById(toId);
        if (to == null) {
            from.addTransaction("Transfer failed: target " + toId + " not found");
            return false;
        }
        if (from.withdraw(amt)) {
            to.deposit(amt);
            from.addTransaction("Transfer to " + toId + " amount " + String.format("%.2f", amt));
            to.addTransaction("Received from " + from.getId() + " amount " + String.format("%.2f", amt));
            return true;
        } else {
            from.addTransaction("Transfer failed (insufficient balance): " + String.format("%.2f", amt));
            return false;
        }
    }
}
