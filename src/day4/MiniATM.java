package day4;

import java.util.Scanner;

public class MiniATM {
    static double balance = 25000;

    //menu
    static void showMenu(){
        System.out.println("\nATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
    };

    //check balance
    static void checkBalance(){
        System.out.println("Your current balance is: INR"+balance);
    }

    //deposit money
    static void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("INR" + amount + "deposited successfully");
        } else {
            System.out.println("Incorrect amount");
        }
    }

    //withdraw money
    static void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("INR" + amount + "withdrawn successfully");
        } else if(amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            System.out.println("Invalid withdrawl amount");
        }
    }

    //main
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while(flag){
            showMenu();
            int choice = input.nextInt();

            switch(choice){
                case 1->
                    checkBalance();
                case 2->{
                    System.out.println("Enter amount to deposit: ");
                    double depositAmount = input.nextDouble();
                    deposit(depositAmount);
                }
                case 3->{
                    System.out.println("Enter amount to withdraw: ");
                    double withdrawAmount = input.nextDouble();
                    withdraw(withdrawAmount);
                }
                case 4->{
                    flag = false;
                    System.out.println("Thank you!");
                }
                default->
                    System.out.println("Invalid choice");
            }
        }
        input.close();
    }
}