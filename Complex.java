package a7;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Complex implements Comparable<Complex>{
	
	/**
	 * NAME: Robert DiDomenico
	 * CLASS: CPSC-24500-001 Object Oriented Programming
	 * DATE: 4/18/2024
	 * PURPOSE: Create a class that computes complex numbers using add, subtract, multiply, divide, and absolute value as methods.
	 */
	
	//Instance variables
	private double a, b;
	
	//Main constructor
	public Complex(double a, double b) {
		this.a = a;
		this.b = b;
	}

	//Partial constructor
	public Complex(double a) {
		this.a = a;
		b = 0;
	}
	
	//Copy constructor
	public Complex(Complex complexNumber) {
		a = complexNumber.getReal();
		b = complexNumber.getImaginary();
	}
	
	//Default constructor
	public Complex() {
		a = 0;
		b = 0;
	}
	
	//Returns the real part of the complex number
	public double getReal() {
		return a;
	}

	//Returns the imaginary part of the complex number
	public double getImaginary() {
		return b;
	}

	//Adds two complex numbers together
	public String add(Complex complexNumber) {
		double realSum = getReal() + complexNumber.getReal();
		double imagSum = getImaginary() + complexNumber.getImaginary();
		return toString() + " + " + complexNumber + " = " + realSum + " + " + imagSum + "i";
	}
	
	//Subtracts two complex numbers together
	public String subtract(Complex complexNumber) {
		double realDiff = getReal() - complexNumber.getReal();
		double imagDiff = getImaginary() - complexNumber.getImaginary();
		return toString() + " - " + complexNumber + " = " + realDiff + " + " + imagDiff + "i";
	}

	//Multiplies two complex numbers together
	public String multiply(Complex complexNumber) {
		double realProd = getReal() * complexNumber.getReal() - getImaginary() * complexNumber.getImaginary();
		double imagProd = getReal() * complexNumber.getImaginary() + getImaginary() * complexNumber.getReal();
		return toString() + " * " + complexNumber + " = " + realProd + " + " + imagProd + "i";
		}

	//Divides two complex numbers together
	public String divide(Complex complexNumber) {
		DecimalFormat f = new DecimalFormat("#0.0000");
		double realQuo = (getReal() * complexNumber.getReal() + getImaginary() * complexNumber.getImaginary()) / 
				(Math.pow(complexNumber.getReal(), 2) + Math.pow(complexNumber.getImaginary(), 2));
		double imagQuo = (getImaginary() * complexNumber.getReal() - getReal() * complexNumber.getImaginary()) / 
				(complexNumber.getReal() * complexNumber.getReal() + complexNumber.getImaginary() * complexNumber.getImaginary());
		return toString() + " / " + complexNumber + " = " + f.format(realQuo) + " + " + f.format(imagQuo) + "i";
	}

	//Returns the absolute value of a complex number
	public double abs() {
		double abs = Math.sqrt(Math.pow(getReal(), 2) + Math.pow(getImaginary(), 2));
		return abs;
	}
	
	@Override
	//Returns a string of the complex number
	public String toString() {
		if (b == 0.0) {
			return "(" + a + ")";
		}
		return "(" + a + " + " + b + "i)";
	}
	
	@Override
	//Compares two complex numbers' absolute values
	public int compareTo(Complex complexNumber) {
		if (abs() < (complexNumber.abs())) {
			return -1;
		} else if (abs() > complexNumber.abs()){
			return 1;
		} else {
			return 0;
		}
	}

	//Main method
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Complex num1, num2;
		
		System.out.print("Enter the first complex number: ");
		num1 = new Complex(in.nextDouble(), in.nextDouble());
		System.out.print("\nEnter the second complex number: ");
		num2 = new Complex(in.nextDouble(), in.nextDouble());
		System.out.println(num1.add(num2));	
		System.out.println(num1.subtract(num2));	
		System.out.println(num1.multiply(num2));	
		System.out.println(num1.divide(num2));	
		System.out.println("|" + num1 + "| = " + num1.abs());
		System.out.println(num1.compareTo(num2));
	}
}