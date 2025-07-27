// Ekum Ark
// CSC142
// Assignment 2


package assignment_2;

import java.util.Scanner;

public class Test_Score_Average {
	
	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter score 1: "); // The program asks for input from user.
		
		int score_1 = console.nextInt(); // User enters score for test 1.
		
		System.out.print("Enter score 2: "); // The program asks for input from user.
		
		int score_2 = console.nextInt(); // User enters score for test 2.
		
		System.out.print("Enter score 3: "); // The program asks for input from user.
		
		int score_3 = console.nextInt(); // User enters score for test 3.
		
		double score_average = (score_1 + score_2 + score_3) / 3.0; // The average score is calculated using the 3 test scores.
		
		if ((score_average % 1) != 0) { // The program checks if the remainder is not equal to 0.
			
			System.out.printf("Average: " + "%.1f", score_average); // The program displays the average score with 1 decimal place instead of multiple digits.
			
			System.out.println(); }
		
		else {
			
			System.out.print("Average: " + score_average); // The program displays the average score.
			
			System.out.println(); }
		
		if (score_average <= 100.0 && score_average >= 90.0) { // The program checks if the average score is between 90.0 to 100.0.
			
			System.out.print("Grade: A");} // The program prints letter grade A.
		
		else if (score_average <= 89.0 && score_average >= 80.0) { // The program checks if the average score is between 80.0 to 89.0.
			
			System.out.print("Grade: B"); } // The program prints letter grade B.
		
		else if (score_average <= 79.0 && score_average >= 70.0) { // The program checks if the average score is between 70.0 to 79.0.
			
			System.out.print("Grade: C"); } // The program prints letter grade C.
		
		else if (score_average <= 69.0 && score_average >= 60.0) { // The program checks if the average score is between 60.0 to 69.0.
			
			System.out.print("Grade: D"); } // The program prints letter grade D.
		
		else if (score_average < 60.0) { // The program checks if the average score is less than 60.0
			
			System.out.print("Grade: F"); } // The program prints letter grade F.
		
	}
	
}
