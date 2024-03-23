package a5;

import java.util.Scanner;

public class Node {
	
	/**
	 * NAME: Robert DiDomenico
	 * CLASS: CPSC-24500-001 Object Oriented Programming
	 * DATE: 3/22/2024
	 * PURPOSE: Create a node class that are coordinates. Create methods for the node values
	 */
	
	//Declaring private variables
	private int x,y;
	
	//Default constructor
	public Node() {
		x = 0;
		y = 0;
	}
	
	//Constructor using another node
	public Node(Node node) {
		x = node.getX();
		y = node.getY();
		checkNums();
	}

	//Constructor using user inputs
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		checkNums();
	}
	
	//Returns x
	public int getX() {
		return x;
	}

	//Returns y
	public int getY() {
		return y;
	}
	
	//Sets x to another number. If that number is above 100 or below -100, it is set to 100 or -100 respectively
	public void setX(int x) {
		if (x <= 100 || x >= -100) {
			this.x = x;
		}
	}

	//Sets y to another number. If that number is above 100 or below -100, it is set to 100 or -100 respectively
	public void setY(int y) {
		if (y <= 100 || y >= -100) {
			this.y = y;
		}
	}
	
	//Adds 2 nodes together
	public void add(Node node) {
		this.x += node.getX();
		this.y += node.getY();
		checkNums();
	}
	
	//Private method to make sure that each number is not above 100 or below -100
	private void checkNums() {
		if (x > 100) {
			x = 100;
		} else if (x < -100) {
			x = -100;
		}
		if (y > 100) {
			y = 100;
		} else if (y < -100) {
			y = -100;
		}
	}
		
	@Override
	//Overrides the toString to make it return the x and y as coordinates
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	//Overrides the equals method to make it return if this node's and another node's x and y values are equal
	public boolean equals(Node node) {
		if (this.x == node.getX() && this.y == node.getY()) {
			return true;
		} else {
			return false;
		}
	}
	
	//Main
	public static void main(String[] args) {
		
		//Declaring variables
		Scanner in = new Scanner(System.in);
		Node n1 = new Node();
		Node n2 = new Node(n1);
		
		//Creating node 3. Catches an exception if the user input is not a number.
		int x = 0;
		int y = 0;
		System.out.print("Enter 2 numbers for x and y: ");
		while (y == 0) {
		    try {
		        x = Integer.parseInt(in.nextLine());
		        y = Integer.parseInt(in.nextLine());
		    } catch (NumberFormatException e) {
		        System.out.println("Invalid input. Input x and y again:");
		    }
		}
		Node n3 = new Node(x, y);
		
		//Prompts the user to change the x of node 2. Catches an exception if the input is not a number 
		int changeX = 0;
		System.out.print("Enter the number to change n2's x: ");
		try {
		    changeX = Integer.parseInt(in.nextLine());
		    n2.setX(changeX);
		} catch (NumberFormatException e) {
		    System.out.println("X was not changed");
		}
		
		//Prompts the user to change the y of node 2. Catches an exception if the input is not a number 
		int changeY = 0;
		System.out.print("Enter the number to change n2's y: ");
		try {
		    changeY = Integer.parseInt(in.nextLine());
		    n2.setY(changeY);
		} catch (NumberFormatException e) {
		    System.out.println("Y was not changed");
		}
		
		//Prompts the user to add node 1 with another node. Catches an exception if the input is not a number or a valid node number 
		int nodeChange = 0;
		System.out.print("Enter the node number to add to node 1 (options are 2 or 3): ");
		try {
			nodeChange = Integer.parseInt(in.nextLine());
		    if (nodeChange == 2) {
		    	n1.add(n2);
		    } else if (nodeChange == 3) {
		    	n1.add(n3);
		    } else {
			    System.out.println("That node does not exist. n1 was not added with another node.");
		    }
		} catch (NumberFormatException e) {
		    System.out.println("n1 was not added with another node.");
		}
		
		//Printing the 3 nodes
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		System.out.println(n1.equals(n2));
	}
}