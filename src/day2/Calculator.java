package day2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        double a = sc.nextDouble();
        System.out.println("Enter the second number: ");
        double b = sc.nextDouble();

        System.out.println("Sum= " + (a+b));
        System.out.println("Differnce= " + (a-b));
        System.out.println("Multiplication= " + (a*b));
        System.out.println("Division= " + (a / b));

        sc.close();
    }
}