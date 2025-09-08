package day10;

import java.util.Scanner;

public class ATMMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank(4);

        // sample accounts
        bank.addAccount(new Account("1001", "Manan", "1234", 50000.00));
        bank.addAccount(new Account("1002", "Randstad", "1111", 700000.00));

        System.out.println("ATM Simulator");

        while (true) {
            System.out.print("\nEnter account id (or 'exit'): ");
            String id = sc.nextLine().trim();
            if (id.equalsIgnoreCase("exit")) break;

            Account acc = bank.findById(id);
            if (acc == null) {
                System.out.println("Account not found.");
                continue;
            }

            System.out.print("Enter PIN: ");
            String pin = sc.nextLine().trim();
            if (!acc.checkPin(pin)) {
                System.out.println("Invalid PIN.");
                continue;
            }

            System.out.println("Login successful. Hi, " + acc.getName());
            boolean loggedIn = true;
            while (loggedIn) {
                System.out.println("\n1) Balance  2) Deposit  3) Withdraw  4) Transfer  5) History  6) Logout");
                System.out.print("Choose: ");
                String choice = sc.nextLine().trim();

                switch (choice) {
                    case "1" -> System.out.printf("Balance: %.2f%n", acc.getBalance());
                    case "2" -> {
                        System.out.print("Amount: ");
                        double amt = sc.nextDouble();
                        acc.deposit(amt);
                        System.out.println("Deposited. New balance: " + String.format("%.2f", acc.getBalance()));
                    }
                    case "3" -> {
                        System.out.print("Amount: ");
                        double amt = sc.nextDouble();
                        boolean ok = acc.withdraw(amt);
                        System.out.println(ok ? "Withdrawn." : "Failed (insufficient/invalid).");
                    }
                    case "4" -> {
                        System.out.print("Target id: ");
                        String toId = sc.nextLine().trim();
                        System.out.print("Amount: ");
                        double amt = sc.nextDouble();
                        boolean ok = bank.transfer(acc, toId, amt);
                        System.out.println(ok ? "Transfer complete." : "Transfer failed.");
                    }
                    case "5" -> {
                        System.out.println("History");
                        String[] tx = acc.getTransactions();
                        for (int i = 0; i < tx.length; i++) System.out.println((i + 1) + ") " + tx[i]);
                        System.out.println("----");
                    }
                    case "6" -> {
                        loggedIn = false;
                        System.out.println("Logged out.");
                    }
                    default -> System.out.println("Invalid option.");
                }
            }
        }

        sc.close();
        System.out.println("Bye.");
    }

}
