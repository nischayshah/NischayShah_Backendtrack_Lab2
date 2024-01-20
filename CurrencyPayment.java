package com.greatlearning.lab2.currencydenomination;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyPayment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the size of currency denominations
        System.out.println("Enter the size of currency denominations");
        int size = scanner.nextInt();

        // Prompt user to enter the currency denominations
        System.out.println("Enter the currency denominations value");
        int[] denominations = new int[size];
        for (int i = 0; i < size; i++) {
            denominations[i] = scanner.nextInt();
        }

        // Prompt user to enter the amount to pay
        System.out.println("Enter the amount you want to pay");
        int amountToPay = scanner.nextInt();

        // Call a method to find the payment approach with the minimum number of notes
        Map<Integer, Integer> paymentApproach = findPaymentApproach(denominations, amountToPay);

        // Display the result in descending order of denominations
        System.out.println("Your payment approach in order to give the minimum number of notes will be");
        Arrays.stream(denominations)
                .filter(paymentApproach::containsKey)
                .boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .forEach(denomination ->
                        System.out.println(denomination + ":" + paymentApproach.get(denomination)));

        // Close the scanner
        scanner.close();
    }

    // Method to find the payment approach with the minimum number of notes
    private static Map<Integer, Integer> findPaymentApproach(int[] denominations, int amountToPay) {
        Arrays.sort(denominations);
        Map<Integer, Integer> paymentApproach = new HashMap<>();

        for (int i = denominations.length - 1; i >= 0; i--) {
            int denomination = denominations[i];
            if (amountToPay >= denomination) {
                int notesCount = amountToPay / denomination;
                paymentApproach.put(denomination, notesCount);
                amountToPay %= denomination;
            }
        }

        return paymentApproach;
    }
}

