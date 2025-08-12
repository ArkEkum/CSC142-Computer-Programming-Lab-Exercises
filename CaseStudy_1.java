// Ekum Ark
// CSC142
// Midterm Exam


package caseStudy_1;

import java.util.Scanner;

public class CaseStudy_1 {
    public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
        System.out.print("What is your annual salary? "); // Program asks user for annual salary.
        double annual_salary = console.nextDouble(); // User enters annual salary.
        System.out.print("On a scale of 1 through 10, what is your credit rating? (10 = excellent, 1 = very bad) "); // Program asks user for credit rating.
        int credit_rating = console.nextInt(); // User enters credit rating.
        if (credit_rating < 1 || credit_rating > 10) { // Program checks if credit rating is below 1 or above 10.
            System.out.print("You did not enter the correct credit rating."); // User did not enter the correct credit rating in the provided range.
            System.exit(0);
        }
        if (annual_salary >=20000 && credit_rating >= 7) { // Program checks if annual salary is above 20000 and credit rating is above 7.
        	qualify(); // Method is called since annual salary is above 20000 and credit rating is above 7.
        } else {
        	noQualify(); // Method is called since annual salary was below 20000 or credit rating was below 7.
        }
        System.exit(0);
    }
    public static void qualify() {
    	System.out.print("Congratulations! You qualify for the credit card!"); // Method displays qualification for credit card.
    }
    public static void noQualify() {
    	System.out.print("Unfortunately, you do not qualify for the credit card."); // Method displays disqualification for credit card.
    }
}