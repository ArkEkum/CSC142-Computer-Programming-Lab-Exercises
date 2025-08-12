// Ekum Ark
// CSC142
// Assignment 4


package assignment_4;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class SalesReport_30Day {

	
	public static void main(String[] args) 
			throws IOException {
		String filePath = getFileName(); // Method is called to get file name from user.
		double[] calc = getTotalSales(filePath); // Method is called to calculate total sales and average daily sales from the file.
		SalesReport.displayResults(calc[0], calc[1]); // Method is called to display the total sales and average daily sales using arrays.
	}
		
	
	public static String getFileName() {		
		Scanner console = new Scanner(System.in);
		System.out.print("Enter the name of the file containing 30 days of sales amount. "); // Asks user to enter file name.
		return console.nextLine(); // Returns the file path to the main method.
	}
	
	
	public static double[] getTotalSales(String fileName)
			throws FileNotFoundException {
		double total = 0.0; // Total variable is declared to calculate the total sales.
		File file = new File(fileName); // Creates new file object to read.
		Scanner inputFile = new Scanner(file); // Scans the file.
		while (inputFile.hasNextDouble()) { // Scans the file until no more numbers can be read.
			total += inputFile.nextDouble(); // Calculates the total sales from the file.
		}
		inputFile.close(); // File is closed.
		double average = total / 30; // Average daily sales are calculated.
		return new double[] {total, average}; // Returns total sales and average daily sales in an array.
	}
	

	public static void displayResults(double total, double average) {
		System.out.printf("The total sales for the period is $" + "%,.2f", total); // Total sales are displayed using correct formatting.
		System.out.println();
		System.out.printf("The average daily sales were $" + "%,.2f", average); // Average daily sales are displayed using correct formatting.
//		String message_1 = String.format("The total sales for the period is $%,.2f", total); // I tried to use JOptionPane to display the pop up boxes but I couldn't get them to work.
//		JOptionPane.showMessageDialog(null, message_1, "User Information", JOptionPane.INFORMATION_MESSAGE); // I tried to use JOptionPane to display the pop up boxes but I couldn't get them to work.
//		String message_2 = String.format("The average daily sales were $%,.2f", average); // I tried to use JOptionPane to display the pop up boxes but I couldn't get them to work.
//		JOptionPane.showMessageDialog(null, message_2, "User Information", JOptionPane.INFORMATION_MESSAGE); // I tried to use JOptionPane to display the pop up boxes but I couldn't get them to work.
	}
	
	
}