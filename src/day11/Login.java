package day11;

import java.util.Scanner;

class invalidLoginException extends Exception{
    public invalidLoginException(String message){
        super(message);
    }
}

public class Login {
    private static final String username = "manan";
    private static final String password = "pass1234";
    private static final int max_attempts = 3;

    public static void login(String user, String pass) throws invalidLoginException{
        if(!user.equals(username) || !pass.equals(password)){
            throw new invalidLoginException(" Invalid username or password");
        }
        System.out.println("Login successful");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int attempts = 0;
        boolean loggedIn = false;

        while(attempts<max_attempts && !loggedIn){
            try{
                System.out.print("Username: ");
                String username = input.nextLine();
                System.out.print("Password: ");
                String password = input.nextLine();

                login(username, password);
                loggedIn = true;
            }
            catch (invalidLoginException e) {
                System.out.println("Login failed " + e.getMessage());
            }
            finally {
                if(!loggedIn) {
                    attempts++;
                    System.out.println("Login attempt #" + attempts);
                }
            }
        }
        if(!loggedIn){
            System.out.println("Too many failed attempts");
        }
        input.close();
    }
}
