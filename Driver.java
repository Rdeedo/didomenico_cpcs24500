package a6;
import a6.Nodes;
import java.util.Scanner;
public class Driver {
	
	public static void displayMenu() {
		System.out.println("1. Fill\n2. Clear\n3. Count Nodes\n4. Count ThreeDNodes\n5. Sort\n6. Display\n7. Exit");
	}
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		Nodes nodes = new Nodes();
		displayMenu();
		int user = in.nextInt();
		while (user != 7) {
			if (user == 1) {
				in.nextLine();
				System.out.println("Enter a size to fill");
				int size = in.nextInt();
				nodes.fill(size);
			} else if (user == 2) {
				nodes.clear();
				System.out.println("Array has been cleared");
			} else if (user == 3) {
				System.out.println("There are " + nodes.countNodes() + " Nodes in this array");			
			} else if (user == 4) {
				System.out.println("There are " + nodes.countThreeDNodes() + " ThreeDNodes in this array");
			} else if (user == 5) {
				nodes.sort();
				System.out.println("Array has been sorted");
			} else if (user == 6) {
				System.out.println(nodes);
			} else {
				System.out.print("Invalid number, please input again");
			}
			displayMenu();
			in.nextLine();
			user = in.nextInt();
		}
	}
}
