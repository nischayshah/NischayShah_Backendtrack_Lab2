package com.greatlearning.lab2.paymoney;
import java.util.Scanner;

public class PayMoneyTransaction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the size of the transaction array
        System.out.println("Enter the size of the transaction array");
        int size = scanner.nextInt();

        // Prompt user to enter the values of the transaction array
        System.out.println("Enter the values of the transaction array");
        int[] transactions = new int[size];
        for (int i = 0; i < size; i++) {
            transactions[i] = scanner.nextInt();
        }

        // Prompt user to enter the total number of targets to achieve
        System.out.println("Enter the total number of targets that need to be achieved");
        int totalTargets = scanner.nextInt();

        // Iterate through each target
        for (int targetIndex = 1; targetIndex <= totalTargets; targetIndex++) {
            // Prompt user to enter the value of the current target
            System.out.println("Enter the value of target " + targetIndex);
            int targetValue = scanner.nextInt();

            // Call a method to find transactions required to achieve the target
            int transactionsRequired = findTransactionsToAchieveTarget(transactions, targetValue);

            // Display the result based on the transactions required
            if (transactionsRequired > 0) {
                System.out.println("Target achieved after " + transactionsRequired + " transaction" +
                        (transactionsRequired > 1 ? "s" : ""));
            } else {
                System.out.println("Given target is not achieved");
            }
        }

        // Close the scanner
        scanner.close();
    }

    // Method to find transactions required to achieve the target
    private static int findTransactionsToAchieveTarget(int[] transactions, int targetValue) {
        int sum = 0;
        int transactionsRequired = 0;

        // Iterate through transactions until the target is achieved
        for (int i = 0; i < transactions.length; i++) {
            sum += transactions[i];
            transactionsRequired++;

            // Check if the accumulated sum is greater than or equal to the target value
            if (sum >= targetValue) {
                break; // Exit the loop if the target is achieved
            }
        }

        // Check if the target is achieved
        if (sum >= targetValue) {
            return transactionsRequired; // Return the number of transactions required
        } else {
            return -1; // Return -1 if the target is not achievable
        }
    }
}



