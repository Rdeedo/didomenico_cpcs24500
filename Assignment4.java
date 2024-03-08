package week8;

import java.util.Scanner;
import java.util.stream.Stream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Assignment4 {

	/**
	 * NAME: Robert DiDomenico
	 * CLASS: CPSC-24500-001 Object Oriented Programming
	 * DATE: 3/6/2024
	 * PURPOSE: Create a file reader that reads numbers from a .txt file
	 */
	
	/**
	 *
	 * @param filename
	 * @return number of lines in a text file
	 * @throws Exception
	 */
	public static int getNoLines(String filename) throws Exception{
		try (Stream<String> fileStream = Files.lines(Paths.get(filename))) {
			return (int) fileStream.count();
		} 
	}

	/**
	 * 
	 * @param filename source file
	 * @return two dim array (jagged array), where each row in the array contains the values in one line of the file,
	 * the length of each row depends on the number of values in each line of the file.
	 * @throws Exception
	 */
	public static int[][] create2DArray(String filename) throws Exception {
		Scanner fsc = new Scanner(new File(filename));
		int[][] arr = new int[getNoLines(filename)][30];
		int lineCount = 0;
		while (fsc.hasNextLine()) {
			String str = fsc.nextLine();
			String[] strs = str.trim().split("\\s+");
			int[] line = new int[strs.length];
			for (int i = 0; i < strs.length; i++) {
				line[i] = Integer.parseInt(strs[i]);
			}
			arr[lineCount] = line;
			lineCount++;
		}
        return arr;
	}
	
	public static int findLongestRow(int[][] arr) {
		int highestRow = 0;
		int index = 0;
		for (int r = 0; r < arr.length; r++) {
			if (highestRow < arr[r].length) {
				highestRow = arr[r].length;
				index = r;
			}
		}
		return index;
	}
	
	public static int findMaxInRow(int[][] arr, int index) {
		int highestNum = 0;
		for (int r = 0; r < arr[index].length; r++) {
			if (highestNum < arr[index][r]) {
				highestNum = arr[index][r];
			}
		}

		return highestNum;
	}
	
	public static int findMax(int[][] arr) {
		int highestNum = 0;
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				if (highestNum < arr[r][c]) {
					highestNum = arr[r][c];
				}	
			}
		}
		return highestNum;
	}
	
	public static void main(String[] args) {
		String filename = "C:\\Users\\bd200\\eclipse-workspace\\OOP\\src\\week8\\assignment4Data.txt";
		if (args.length <1) {
			System.out.println("usage: Assignment4 inputFilename ");
			
		}
		int arr[][] = null;
		try {
			Scanner fsc = new Scanner(new File(filename));
			System.out.println("Number of lines in the file ="+ getNoLines(filename));
			arr = create2DArray(filename);
			int longestRow = findLongestRow(arr);
			System.out.println("Longest row in the file is: "+ (longestRow+1)+" ,with length of: "
			                      +arr[longestRow].length);
			System.out.println("Max value in first row = "+ findMaxInRow(arr, 0));
			System.out.println("Max value in file = "+ findMax(arr));
		} catch (Exception e) {
			System.out.print(e);
		}
	}

}