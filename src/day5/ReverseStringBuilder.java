package day5;

import java.util.Scanner;

public class ReverseStringBuilder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder(str);
        String reverse = sb.reverse().toString();

        System.out.println("Original: " + str);
        System.out.println("Reversed: " + reverse);
    }
}
