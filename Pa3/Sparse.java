// Sparse.java
// Diego Magdaleno
// dmmagdal
// pa3: Client for performing matrix operations on Matrix ADT

import java.util.Scanner;
import java.io.*;

public class Sparse{
	public static void main(String[] args){
		Scanner in = new Scanner(new FileReader(args[0]));
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));

		while (in.hasNextLine()){
			String[] input = inNextLine().split("\\s+");

			// initialize matrices in "first" line
			Matrix a = new Matrix(input[0]);
			Matrix b = new Matrix(input[0]);

		}
	}
}