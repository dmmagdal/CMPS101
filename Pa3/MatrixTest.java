// MatrixTest.java
// Diego Magdaleno
// dmmagdal
// Pa3: Test the Matrix ADT

public class MatrixTest{
	public static void main(String[] args) {

		// test initialization, retrieving size, and nnnx functions
		Matrix a = new Matrix(2);
		System.out.println("Matrix A has size of: "+a.getSize());							// passed: correct output is 2
		System.out.println("Matrix A has this many non zero numbers: "+a.getNNZ());			// passed: correct output is 0

		// test changeEntry
		a.changeEntry(1, 2, 5.0);															// matrix should be [2.1 5.0]
		a.changeEntry(1, 1, 2.1);															// 					[1.1 0.0]
		a.changeEntry(2, 1, 1.1);
		a.changeEntry(2, 1, 0.3);
		a.changeEntry(2, 2, 3.1);
		a.changeEntry(1, 2, 0.7);															// can successfully overwrite any entry

		System.out.println("Matrix A has size of: "+a.getSize());							// passed: correct output is 2
		System.out.println("Matrix A has this many non zero numbers: "+a.getNNZ());			// passed: correct output is 3

		System.out.print(a.toString());														// toString function works
		System.out.println("");

		/*
		Matrix b = new Matrix(a.getSize());
		b.changeEntry(1, 1, 2.1);
		b.changeEntry(1, 2, 0.7);
		b.changeEntry(2, 1, 0.3);
		b.changeEntry(2, 2, 3.1);

		System.out.println(b.equals(a));

		System.out.print(b.toString());

		System.out.println("making b zero");
		b.makeZero();
		System.out.print(b.toString());
		*/
		
		// test copy, makezero, and equals
		Matrix b = a.copy();
		System.out.print(b.toString());
		System.out.println("");

		System.out.println("Created matrix b to be a copy of a. Is b equal to a?: "+b.equals(a)+"\n");

		b.makeZero();
		System.out.print(b.toString());
		System.out.println("");

		System.out.println("Zeroed matrix b. Is b equal to a?: "+b.equals(a));			// passed: correct output given
		System.out.println("");
		
		
		// test transpose
		Matrix c = a.transpose();														// passed: correct output given
		System.out.print(c.toString());
		System.out.println("");
		

		// test scalar mult
		Matrix d = a.scalarMult(2.0);													// paased: correct output given
		System.out.print(d.toString());
		System.out.println("");

		// test add
		Matrix e = a.add(d);
		System.out.print(e.toString());													// passed: correct output given
		System.out.println("");

		// test sub
		Matrix f = e.sub(d);
		System.out.print(f.toString());													// passed: correct output given
		System.out.println("");

		
		// test mult
		Matrix g = a.mult(e);															//
		System.out.print(g.toString());
		System.out.println("");
		
	}
}