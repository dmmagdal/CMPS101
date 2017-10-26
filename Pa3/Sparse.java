// Sparse.java
// Diego Magdaleno
// dmmagdal
// pa3: Client for performing matrix operations on Matrix ADT

import java.util.Scanner;
import java.io.*;

public class Sparse{
	public static void main(String[] args) throws IOException, FileNotFoundException{
		Scanner in = new Scanner(new FileReader(args[0]));						// new scanner object to read from file
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));				// new printwriter object to write to file

		Matrix A, B;															// new matrix variables

		int lineNum = 0;														// int to hold line number from input file
		
		String[] input = in.nextLine().split("\\s+");							// read first line of the file to set up variables
		A = new Matrix(Integer.parseInt(input[0]));								// initialize matrices
		B = new Matrix(Integer.parseInt(input[0]));
		int Ainput = Integer.parseInt(input[1]);								// ints to hold the number of non-zero entries for A and B
		int Binput = Integer.parseInt(input[2]);

		String blank = in.nextLine();
		while (in.hasNextLine() && lineNum < Ainput){							// scan lines to enter the entries into the matrix
			String[] entry = in.nextLine().split("\\s+");
			A.changeEntry(Integer.parseInt(entry[0]), Integer.parseInt(entry[1]), Double.parseDouble(entry[2]));
			lineNum++;
		}

		blank = in.nextLine();
		lineNum = 0;															// reset line counter
		while (in.hasNextLine() && lineNum < Binput){
			String[] entry = in.nextLine().split("\\s+");
			B.changeEntry(Integer.parseInt(entry[0]), Integer.parseInt(entry[1]), Double.parseDouble(entry[2]));
			lineNum++;
		}

		// perform operations
		out.println("A has "+A.getNNZ()+" non-zero entries: ");
		out.print(A.toString());
		out.println("");

		out.println("B has "+B.getNNZ()+" non-zero entries: ");
		out.print(B.toString());
		out.println("");

		out.println("(1.5)*A =");
		out.print(A.scalarMult(1.5).toString());
		out.println("");

		out.println("A+B = ");
		out.print(A.add(B).toString());
		out.println("");

		out.println("A+A =");
		out.print(A.add(A).toString());
		out.println("");

		out.println("B-A =");
		out.print(B.sub(A).toString());
		out.println("");

		out.println("A-A =");
		out.print(A.sub(A).toString());
		out.println("");

		out.println("Transpose(A) =");
		out.print(A.transpose().toString());
		out.println("");

		out.println("A*B = ");
		out.print(A.mult(B).toString());
		out.println("");

		out.println("B*B = ");
		out.print(B.mult(B).toString());
		out.println("");

		in.close();
		out.close();
	}
}