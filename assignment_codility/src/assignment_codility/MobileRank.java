package assignment_codility;

import java.util.*;

public class MobileRank {

    // Inner class to store mobile number and its rank
    static class Mobile {
        String number;
        int rank;

        Mobile(String number, int rank) {
            this.number = number;
            this.rank = rank;
        }
    }

    // Method to calculate rank based on certain conditions
    private static int calculateRank(String number) {
        int rank = 0;

        // Check if the number is in ascending order
        boolean isAscending = true;
        for (int i = 1; i < number.length(); i++) {
            if (number.charAt(i) < number.charAt(i - 1)) {
                isAscending = false;
                break;
            }
        }
        if (isAscending) rank += 30;  // Highest rank for ascending order

        // Check if the number is in descending order
        boolean isDescending = true;
        for (int i = 1; i < number.length(); i++) {
            if (number.charAt(i) > number.charAt(i - 1)) {
                isDescending = false;
                break;
            }
        }
        if (isDescending) rank += 20;  // Second highest rank for descending order

        // Count repeated digits
        Set<Character> uniqueDigits = new HashSet<>();
        int repeatedDigitsCount = 0;
        for (char digit : number.toCharArray()) {
            if (!uniqueDigits.add(digit)) {
                repeatedDigitsCount++;
            }
        }
        rank += (repeatedDigitsCount * 5);  // Add 5 for each repeated digit

        return rank;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of mobile numbers:");
        int totalMobiles = scanner.nextInt();
        scanner.nextLine();  // Consume the leftover newline

        List<String> mobileNumbers = new ArrayList<>();
        for (int i = 0; i < totalMobiles; i++) {
            System.out.println("Enter mobile number " + (i + 1) + ":");
            String mobileNumber = scanner.nextLine();

            // Validate mobile number (must be exactly 10 digits)
            if (mobileNumber.length() != 10 || !mobileNumber.matches("\\d{10}")) {
                System.out.println("Invalid mobile number! It must be exactly 10 digits. Skipping this number.");
                continue;
            }

            mobileNumbers.add(mobileNumber);
        }

        // List to store Mobile objects (mobile number and its rank)
        List<Mobile> rankedMobiles = new ArrayList<>();
        for (String number : mobileNumbers) {
            int rank = calculateRank(number);
            rankedMobiles.add(new Mobile(number, rank));
        }

        // Sort mobiles by rank (highest rank first), then by number (ascending order)
        rankedMobiles.sort((a, b) -> {
            if (a.rank != b.rank) {
                return Integer.compare(b.rank, a.rank);  // Higher rank comes first
            } else {
                return a.number.compareTo(b.number);  // If ranks are the same, sort by number
            }
        });

        // Display the sorted mobile numbers with their ranks
        System.out.println("\nMobile Numbers Ranked:");
        int currentRank = 1;
        for (Mobile mobile : rankedMobiles) {
            System.out.println("Rank: " + currentRank + " | Mobile Number: " + mobile.number);
            currentRank++;
        }

        scanner.close();
    }
}

