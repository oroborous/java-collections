package edu.wctc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainWithMapOfMerchants {
    public static void main(String[] args) {
        Map<Merchant, Double> purchaseMap = new HashMap<>();

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the expense tracker!");

        char response = 'y';
        do {
            System.out.print("Enter merchant name: ");

            String name = keyboard.nextLine();

            System.out.println("Enter merchant address: ");

            String address = keyboard.nextLine();

            Merchant merchant = new Merchant(name, address);

            System.out.print("Enter purchase amount: ");

            double amount = Double.parseDouble(keyboard.nextLine());

            if (!purchaseMap.containsKey(merchant))
                purchaseMap.put(merchant, 0.0);

            purchaseMap.put(merchant, purchaseMap.get(merchant) + amount);

            System.out.print("Do you have more receipts to enter? (y/n) ");

            response = keyboard.nextLine().toLowerCase().charAt(0);

        } while (response == 'y');

        System.out.println();

        // print all keys and values
        for (Map.Entry<Merchant, Double> mapEntry : purchaseMap.entrySet()) {
            Merchant key = mapEntry.getKey();

            Double value = mapEntry.getValue();

            System.out.printf("You spent %.2f at %s%n", value, key.getName());
        }

        System.out.println("Thank you for using the expense tracker!");
    }
}
