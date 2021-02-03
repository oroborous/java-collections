package edu.wctc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem: Write an expense tracker program that allows the user
 * to enter any number of purchase receipts.
 * For each receipt, the user is prompted for a merchant name and purchase amount.
 * When the user is done entering receipts, the program outputs each merchant
 * and the total spent at that merchant.
 */
public class Main {
    // Increasing the array size results in fewer collisions,
    // but also more wasted space.
    private static final int ARRAY_SIZE = 100;

    public static void main(String[] args) {

        List<String> merchantNames = new ArrayList<>();

        Double[] purchaseAmounts = new Double[ARRAY_SIZE];

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the expense tracker!");

        char response = 'y';
        do {
            System.out.print("Enter merchant name: ");

            String name = keyboard.nextLine();

            merchantNames.add(name);

            System.out.print("Enter purchase amount: ");

            double amount = Double.parseDouble(keyboard.nextLine());

            int hashCode = getTerribleHashCode(name);

            System.out.printf("The terrible hash code for %s is %d%n", name, hashCode);

            // Because we used the wrapper class Double and not the primitive double,
            // the array is initially full of nulls
            if (purchaseAmounts[hashCode] == null)
                purchaseAmounts[hashCode] = 0.0;

            purchaseAmounts[hashCode] += amount;

            System.out.print("Do you have more receipts to enter? (y/n) ");

            response = keyboard.nextLine().toLowerCase().charAt(0);

        } while (response == 'y');

        System.out.println();

        // print all keys and values
        for (String key : merchantNames) {
            // Hash the key again to find the corresponding array index
            int hashCode = getTerribleHashCode(key);

            System.out.printf("You spent %.2f at %s%n", purchaseAmounts[hashCode], key);
        }

        System.out.println("Thank you for using the expense tracker!");
    }

    /*
    This is a terrible hash function because it is very likely to produce the same
    key for different inputs (a collision). A good hash function should produce a unique
    key for each unique input.

    For example, if you input "Walmart" you get (87+97+108+109+97+114+116) % 100, or 28.
    If you input "Office Depot" you get (79+102+102+105+99+101+32+68+101+112+111+116) % 100, which is also 28.
     */
    public static int getTerribleHashCode(String name) {
        // Add all the ASCII values of the letters together
        char[] nameChars = name.toCharArray();

        int sum = 0;

        for (char c : nameChars) {
            sum += c;
        }

        // Mod by 100 so the key will be between 0 and 99 and fit in our array

        int hashCode = sum % ARRAY_SIZE;

        return hashCode;
    }
}
