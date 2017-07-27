// Lex.java
// Diego Magdaleno
// dmmagdal
// pa1: Takes file input and sorts the data lexicographically (in order) using the List ADT

import java.util.Scanner;
import java.io.*;

public class Lex{
	public static void main(String[] args) throws IOException, FileNotFoundException, NullPointerException{

		// if there aren't exactly two arguments, print this error message and exit the program
		if (args.length != 2){
			System.err.println("Usage: Lex infile outfile");
			System.exit(1);
		}

		// otherwise, continue on

		Scanner in = new Scanner(new File(args[0]));								// variable to take input from the input file 
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));					// variable to write to the output file
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));		// variable to read through the input file

		
		int lineCount = 0;															// int to hold number of lines in the input file
		// while the reader and can read through a line, increment the line count
		while (reader.readLine() != null){
			lineCount++;
		}

		// String array to hold data from input file
		String[] input = new String[lineCount];										// string array to hold all input from the input file, uses lineCount variable from above for the size 
		int index = 0;																// int holds the index for thie input[] string array, starting from zero
		// while the input variable has a next line, store the line to the input[] string array and increment the index variable
		while (in.hasNextLine()){
			input[index] = in.nextLine();
			index++;
		}

		/* // test to see if the input was being copied correctly to the string array. Gives coorect output
		for (int j = 0; j < input.length; j++){
			out.println(input[j]);
			System.out.println(input[j]);

		}*/

		List indices = new List();													// initialize new list object to store indices
		// start the sorting
		indices.append(0);	// input[0]
		
		for (int i = 1; i < input.length; i++){
			indices.moveFront();
			if (input[i].compareTo(input[indices.get()]) <= 0){
				indices.insertBefore(i);
			}
			else {	//arg[i].compareT0(arg[l.get()]) > 0
				while (input[i].compareTo(input[indices.get()]) > 0){
					indices.moveNext();
				}
				indices.insertBefore(i);
			}
		}

		// print to file
		indices.moveFront();
		for (int l = 0; l < indices.length(); l++){
			out.println(input[indices.get()]);
			System.out.println(input[indices.get()]);
			indices.moveNext();
		}

		
		// close the variables to read, scan, and write the files
		in.close();
		out.close();
		reader.close();
	}
}