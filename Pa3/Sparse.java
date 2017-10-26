// Sparse.java
// Diego Magdaleno
// dmmagdal
// pa3: Client for performing matrix operations on Matrix ADT

import java.util.Scanner;
import java.io.*;

public class Sparse{
	public static void main(String[] args){
		Scanner in = new Scanner(new FileReader(args[0]));						// new scanner object to read from file
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));				// new printwriter object to write to file

		Matrix A, B;															// new matrix variables

		int lineNum = 0;														// int to hld line number from input file
		int Ainput;																// ints to hold the number of non-zero entries for A and B
		int Binput;
		while (in.hasNextLine()){												// while the scanner can read from the file
			String[] input = in.nextLine().split("\\s+");

			if (lineNum == 0){													// if it's the first line of the file
				// input[0] holds matrix size
				// input[1] holds matrix A nnz
				// input[2] holds matrix B nnz

				// initialize matrices in "first" line
				A = new Matrix(Integer.parseInt(input[0]));										// initialize A and B size
				B = new Matrix(Integer.parseInt(input[0]));

				// set up variables to scan for nonzero entries for the matrices
				Ainput = Integer.parseInt(input[1]);												// give the nnz variables above an actual value so that way they can scan and enter the apporpriate number of entries
				Binput = Integer.parseInt(input[2]);
			}

			if (lineNum%(Ainput+1) != 0){

			}
			

		}

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