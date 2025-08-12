// Ekum Ark
// CSC142
// Midterm Exam


package caseStudy_2;

import java.io.*;
import java.util.*;

public class CaseStudy_2 {
	public static void main(String[] args) // Main method for entire class.
			throws IOException {
		String filePath = getFileName(); // Method is called to get file name from user.
		double[] calc = getTotalSales(filePath); // Method is called to calculate total sales and average daily sales from the file.
		CaseStudy_2.displayResults(calc[0], calc[1]); // Method is called to display the total sales and average daily sales using arrays.
	}	
	public static String getFileName() { // Method asks user to enter file name.
		Scanner console = new Scanner(System.in);
		System.out.print("Enter the name of the file containing 30 days of sales amount. "); // Asks user to enter file name.
		return console.nextLine(); // Returns the file path to the main method as a string.
	}
	public static double[] getTotalSales(String fileName) // Method accepts string for file name.
			throws FileNotFoundException {
		double total = 0.0;
		File file = new File(fileName); // Creates new file object to read.
		Scanner inputFile = new Scanner(file); // Scans the file.
		while (inputFile.hasNextDouble()) { // Scans the file until no more doubles can be read.
			total += inputFile.nextDouble(); // Calculates the total sales from the file.
		}
		inputFile.close();
		double average = total / 30; // Average daily sales are calculated.
		return new double[] {total, average}; // Returns total sales and average daily sales in an array.
	}
	public static void displayResults(double total, double average) { // Method accepts two doubles for total sales and average daily sales.
		System.out.printf("The total sales for the period is $" + "%,.2f", total); // Total sales are displayed.
		System.out.println();
		System.out.printf("The average daily sales were $" + "%,.2f", average); // Average daily sales are displayed.
	}
}