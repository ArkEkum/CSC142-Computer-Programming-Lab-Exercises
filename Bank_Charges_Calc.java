// Ekum Ark
// CSC142
// Assignment 2


package assignment_2;

import java.util.Scanner;

public class Bank_Charges_Calc {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter number of checks: "); // The program asks for the number of checks.
		
		int num_of_checks = console.nextInt(); // User enters number of checks.
		
		double base_fee = 10.00; // The base fee is $10.00.
		
		System.out.printf("Base fee: $" + "%.2f", base_fee); // The program displays the base fee with 2 decimal places.
		
		System.out.println();
		
		if (num_of_checks >= 60) { // The program checks if the number of checks is more than or equal to 60.
			
			double fee_per_check = 0.04; // The fee per check for 60 or more checks.
			
			System.out.println("Fee per check: $" + fee_per_check); // The program displays the fee per check.
			
			double total = base_fee + fee_per_check * num_of_checks; // The program calculates the total with the base fee and fee per check.
			
			System.out.printf("Total service charge: $" + "%.2f", total); } // The program displays the total service charge.
		
		else if (num_of_checks <= 59 && num_of_checks >= 40) { // The program checks if the number of checks is between 40 and 59.
			
			double fee_per_check = 0.06;  // The fee per check for 40 to 59 checks.
			
			System.out.println("Fee per check: $" + fee_per_check); // The program displays the fee per check.
			
			double total = base_fee + fee_per_check * num_of_checks; // The program calculates the total with the base fee and fee per check.
			
			System.out.printf("Total service charge: $" + "%.2f", total); } // The program displays the total service charge.
		
		else if (num_of_checks <= 39 && num_of_checks >= 20) { // The program checks if the number of checks is between 20 and 39.
			
			double fee_per_check = 0.08;  // The fee per check for 20 to 39 checks.
			
			System.out.println("Fee per check: $" + fee_per_check);  // The program displays the fee per check.
			
			double total = base_fee + fee_per_check * num_of_checks; // The program calculates the total with the base fee and fee per check.
			
			System.out.printf("Total service charge: $" + "%.2f", total); } // The program displays the total service charge.
		
		else if (num_of_checks < 20) { // The program checks if the number of checks is less than 20.
			
			double fee_per_check = 0.10;  // The fee per check for less than 20 checks.
			
			System.out.println("Fee per check: $" + fee_per_check); // The program displays the fee per check.
			
			double total = base_fee + fee_per_check * num_of_checks; // The program calculates the total with the base fee and fee per check.
			
			System.out.printf("Total service charge: $" + "%.2f", total); } // The program displays the total service charge.
		
	}

}
