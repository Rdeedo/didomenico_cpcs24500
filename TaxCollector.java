package week4;
import java.util.Scanner;
public class TaxCollector {
	/***
	/ NAME: Robert DiDomenico
	/ CLASS: CPSC-24500-001 Object Oriented Programming
	/ DATE: 2/10/2024
	/ PURPOSE: Compute the amount of J$ tax with a given income
	*/
	
	//Declaring private variables
	private String name;
	private int income; 
	private double tax;
	
	//Constructor for the class
	public TaxCollector(String name, int income) {
		this.name = name;
		this.income = income;
	}
	
	//Calculates the amount of tax money
	public double computeTax() {
		
		//Checks to make sure that the input is a number greater than or equal to 0
		if (income < 0) {
			System.out.println("Invalid Input");
			System.exit(0);
		}
		
		//Calculates the amount of tax and returns it
		if (income <= 4000) {
			tax = 0;
		} else if (income <= 5500) {
			tax = .1 * (income - 4000);
		} else if (income <= 33500) {
			tax = (.1 * 1500) + (.2 * (income - 5500));
		} else { 
			tax = (.1 * 1500) + (.2 * 28000) + (.4 * (income - 33500));
		}
		return tax;
	}
	
	// Prints all information about the person
	public void getInfo() {
		System.out.println("Name: " + name);
		System.out.println("Income: " + income);
		System.out.println("Income Tax: " + tax);
	}
	
	public static void main(String[] args) {
		
		//Gets the user input for name and tax
		Scanner in = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = in.nextLine();
		System.out.println("What is your income?");
		int income = in.nextInt();
		
		//Shows the console the information about the user
		TaxCollector p1 = new TaxCollector(name, income);
		p1.computeTax();
		p1.getInfo();
	}
}
