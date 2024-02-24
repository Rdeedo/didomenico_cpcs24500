package week6;
import java.util.Random;
import java.util.Scanner;
public class RPSsimulator {

	/***
	/ NAME: Robert DiDomenico
	/ CLASS: CPSC-24500-001 Object Oriented Programming
	/ DATE: 2/21/2024
	/ PURPOSE: Create a game that simulates a game of Rock, Paper, Scissors
	*/
	
	//Declaring instance variables
	private int compChoice;
	private Random gen = new Random();
	
	//Constructor
	public RPSsimulator() {
		compChoice = gen.nextInt(3) + 1;
	}
	
	//Returns the computer's choice of rock, paper, or scissors
	public int getCompChoice() {
		return compChoice;
	}
	
	//Re-randomizes the computer's choice
	public void getAnotherChoice() {
		compChoice = gen.nextInt(3) + 1;
	}

	//Prints out the results of the RPS draw with the given numbers
	public void getResults(int user, int comp) {
		if (user == 1) {
			System.out.println("You chose rock");
		} else if (user == 2) {
			System.out.println("You chose paper");
		} else {
			System.out.println("You chose scissors");
		}
		if (comp == 1) {
			System.out.println("The computer chose rock");		
		} else if (comp == 2) {
			System.out.println("The computer chose paper");		
		} else {
			System.out.println("The computer chose scissors");		
		}
	}
	
	public static void main(String[] args) {
		
		//Declaring variables
		Scanner in = new Scanner(System.in);
		RPSsimulator sim = new RPSsimulator();
		String answer = "y";
		
		//Loop to keep the game going if the user answers yes
		while (answer.equals("Y") || answer.equals("y")) {
			
			//Initial user response
			System.out.print("Enter Rock (1), Paper(2), or Scissors(3): ");
			int userInput = in.nextInt();
			
			//Checks to see if the user input is valid and requires them to fix it if not
			while (userInput != 1 && userInput != 2 && userInput != 3) {
				System.out.print("Please re-enter a valid number (1, 2, or 3): ");
				userInput = in.nextInt();
			}
			
			//Prints the results from the given options
			sim.getResults(userInput, sim.getCompChoice());
			
			//Checks to see if the results are the same and makes the user replay the game if the results match
			while (userInput == sim.getCompChoice()) {
				System.out.print("You both picked the same option. Play again\n");			
				sim.getAnotherChoice();
				System.out.print("Enter Rock (1), Paper(2), or Scissors(3): ");
				userInput = in.nextInt();
				while (userInput != 1 && userInput != 2 && userInput != 3) {
					System.out.print("Please re-enter a valid number (1, 2, or 3): ");
					userInput = in.nextInt();
				}	
				sim.getResults(userInput, sim.getCompChoice());
			}
			
			//Determines the winner of the game
			if (userInput == 1 && sim.getCompChoice() == 2) {
				System.out.println("You Lose.");
			} else if (userInput == 1 && sim.getCompChoice() == 3) {
				System.out.println("You Win!");
			} else if (userInput == 2 && sim.getCompChoice() == 1) {
				System.out.println("You Win!");
			} else if (userInput == 2 && sim.getCompChoice() == 3) {
				System.out.println("You Lose.");
			} else if (userInput == 3 && sim.getCompChoice() == 1) {
				System.out.println("You Lose.");
			} else if (userInput == 3 && sim.getCompChoice() == 2) {
				System.out.println("You Win!");
			}
			
			//Asks the user if they want to play again
			System.out.println("Would you like to play again? [Y or N] ");
			in.nextLine();
			answer = in.nextLine();
		}
		
		//Closing
		System.out.println("Goodbye!");		
	}
}