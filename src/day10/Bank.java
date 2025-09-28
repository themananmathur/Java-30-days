package day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private final Map<String, Account> accounts;

    public Bank(){
        accounts = new HashMap<>();
    }

    public void addAccount(Account a){
        accounts.put(a.getId(), a);
    }

    public Account findById(String id) {
        return accounts.get(id);
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
