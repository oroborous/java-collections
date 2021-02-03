package edu.wctc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainWithMap {
    public static void main(String[] args) {
        Map<String, Double> purchaseMap = new HashMap<>();

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the expense tracker!");

        char response = 'y';
        do {
            System.out.print("Enter merchant name: ");

            String name = keyboard.nextLine();

            System.out.print("Enter purchase amount: ");

            double amount = Double.parseDouble(keyboard.nextLine());

            if (!purchaseMap.containsKey(name))
                purchaseMap.put(name, 0.0);

            purchaseMap.put(name, purchaseMap.get(name) + amount);

            System.out.print("Do you have more receipts to enter? (y/n) ");

            response = keyboard.nextLine().toLowerCase().charAt(0);

        } while (response == 'y');

        System.out.println();

        // print all keys and values
        for (Map.Entry<String, Double> mapEntry : purchaseMap.entrySet()) {
            String key = mapEntry.getKey();

            Double value = mapEntry.getValue();

            System.out.printf("You spent %.2f at %s%n", value, key);
        }

        System.out.println("Thank you for using the expense tracker!");
    }
}
