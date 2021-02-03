package edu.wctc;

import java.util.*;

public class MainWithMapOfLists {
    public static void main(String[] args) {
        Map<String, List<Double>> purchaseMap = new HashMap<>();

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the expense tracker!");

        char response = 'y';
        do {
            System.out.print("Enter merchant name: ");

            String name = keyboard.nextLine();

            System.out.print("Enter purchase amount: ");

            double amount = Double.parseDouble(keyboard.nextLine());

            if (!purchaseMap.containsKey(name))
                purchaseMap.put(name, new ArrayList<>());

            purchaseMap.get(name).add(amount);

            System.out.print("Do you have more receipts to enter? (y/n) ");

            response = keyboard.nextLine().toLowerCase().charAt(0);

        } while (response == 'y');

        System.out.println();

        // print all keys and values
        for (Map.Entry<String, List<Double>> mapEntry : purchaseMap.entrySet()) {
            String key = mapEntry.getKey();

            List<Double> value = mapEntry.getValue();

            System.out.printf("Your %s purchases were: %s%n", key, value.toString());
        }

        System.out.println("Thank you for using the expense tracker!");
    }
}
