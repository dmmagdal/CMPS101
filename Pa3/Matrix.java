// Matrix.java
// Diego Magdaleno
// dmmagdal
// pa3: Matrix ADT

public class Matrix{
	private int size;										// how large the matrix is (n x n)
	private int nnz;										// how many non zero entries there are
	private List[] row;										// array of list of entries

	// Matrix constructor
	public Matrix(int n){
		if (n >= 1){
			size = n;										// set the size to n
			row = new List[n+1];							// create a new array of integer lists (note that row[0] holds an empty list)
			for (int i = 0; i <= size; i++){
				row[i] = new List();						// initialize a new list object in every row
			}
		}
	}


	// Access functions


	/** gives how large the matrix is
	@param takes no arguments
	@return returns the size of the matrix **/
	public int getSize(){
		return size;										// return the size variable
	}

	/** gives how many non zero entries are in the matrix
	@param takes no arguments
	@return returns the non zero entries number **/
	public int getNNZ(){
		int counter = 0;									// initialize a counter 
		for (int i = 1; i <= size; i++){
			counter += row[i].length();						// go through each row and add that row's length to the counter
		}
		nnz = counter;										// set nonzero number to the counter from above
		return nnz;											// return the counter
	}

	/** overrides Object's equals() method
	@param takes the argument Matrix m to compare to 
	@return returns true if the matrces are exactly the same, false otherwise **/
	public boolean equals(Object x){
		boolean equal;										// create a boolean object and set it to true
		if (x instanceof Matrix){							// if x is an instance of the Matrix class
			equal = true;									// set boolean to true until proven otherwise
			Matrix m = (Matrix)x;							// convert object x into matrix and set that to matrix m
			if (m.getSize() != size || m.getNNZ() != nnz){	// if the size or nonzero numbers are not the same 
				equal = false;								// set equal boolean to false
			}
			else{											// otherwise, if the equal boolean is not false
				for (int i = 1; i <= size; i++){
					if (!row[i].equals(m.row[i])){			// if the rows are not equal
						equal = false;						// set equal boolean to false 
					}
				}
			}
		}
		else{
			equal = false;									// otherwise the boolean is false
		}
		return equal;										// return the boolean
	}


	// Manipulation procedures


	/** sets matriz to zero state
	@param takes no arguments
	@return returns nothing **/
	public void makeZero(){
		for (int i = 1; i <= size; i++){
			row[i].clear();									// clear each of the rows
		}
	}

	/** creates a copy of the current matrix
	@param takes no arguments 
	@return returns a new matrix with the same entries as the current one **/
	public Matrix copy(){
		Matrix cp = new Matrix(size);						// create new matrix object of the same size for the copy 
		for (int i = 1; i <= size; i++){
			row[i].moveFront();								// set cursor to front of matrix list
			while (row[i].get() != null){					// while the cursor for the list is not null
				Entry rowEntry = (Entry) row[i].get();		// create a new variable to hold the node data retrieved from the List's cursor
				cp.changeEntry(i, rowEntry.getColumn(), rowEntry.getEntry());	// insert new data at that cursor
				row[i].moveNext();							// move the cursor along the list
			}
		}
		return cp;											// return the matrix copy
	}

	/** changes the ith row, jth column of the matrix to x
	@param integer i for the ith row
	@param integer j for the jth column
	@param double x for the entry to be placed
	@return returns nothing **/
	public void changeEntry(int i, int j, double x){
		if (i >= 1 && i <= size && j >= 1 && j <= size){
			Entry e = new Entry(j, x);						// create new entry object
			if (row[i].length() == 0){						// if the target row is empty
				row[i].append(e);							// append the entry to the row. 		
			}
			else {											// otherwise the target row is not empty
				row[i].moveFront();							// move cursor to front
				while (row[i].get() != null){				// while the cursor is not null
					Entry rowCursor = (Entry) row[i].get();	// Entry object used to store cursor data
					if (j <= rowCursor.getColumn()){		// if the entry object is less than or equal to the cursor column
						row[i].insertBefore(e);				// insert it in front of the cursor
						if (j == rowCursor.getColumn()){	// if the entry object is exactly equal to the cursor column
							row[i].delete();				// delete the cursor (which breaks the loop)
						}
						else{								// otherwize (the entry object is less than the cursor column, so we have to break the loop another way)
							row[i].moveBack();				// move the cursor to the back and then have it run off the list
							row[i].moveNext();
						}
					}
					else if (row[i].get().equals(row[i].back()) && j > rowCursor.getColumn()){	// cursor is at the back and the cursor column is less than the entry object
						row[i].append(e);					// append the object to the back of the list
						row[i].moveBack();					// move the cursor to the back and then have it run off the list
						row[i].moveNext();
					}
					else { 									// j > rowCursor.getCloumn()
						row[i].moveNext();					// move the cursor along the list
					}

					/*			Old Code
					if (rowCursor.getColumn() > j){			// if the cursor "index" is greater than j
						row[i].insertBefore(e);				// insert the entry before the cursor
						row[i].moveBack();					// set cursor to the back of the list
						row[i].moveNext();					// iterate cursor along to make it null and break the loop
					}
					else if (rowCursor.getColumn() == j){	// if the cursor "index" is j (there already exists an element in the list with the same column)
						row[i].insertBefore(e);				// insert the new entry before the cursor
						row[i].delete();					// delete the former cursor element (sets cursor to null breaking the loop)
					}
					else if (rowCursor.getColumn() < j && row[i].get().equals(row[i].back())){	// if the cursor "index" is less than j and the cursor is the back
						row[i].insertAfter(e);				// insert the new entry after the cursor
						row[i].moveBack();					// set cursor to the back of the list
						row[i].moveNext();					// iterate cursor along to make it null and break the loop
					}
					else if (rowCursor.getColumn() < j && !row[i].get().equals(row[i].back())){	// if the cursor "index" is less than j and the cursor is isn't the back
						row[i].moveNext();					// move the cursor to the next entry on the list
					}
					*/


				}
			}
		}
		else{
			throw new InvalidEntryException();
		}
	}

	/** multiplies matrix by a scalar value
	@param takes a double x to be te scalar value multiplied
	@return returns a new matrix that is the scalar product of this matrix with x **/
	public Matrix scalarMult(double x){
		Matrix smult = new Matrix(size);					// create a new matrix object to hold the scalar multiplication of a matrix
		for (int i = 1; i <= size; i++){
			List newrow = new List();						// create a new list (temporary)
			row[i].moveFront();								// move the cursor to the front
			while (row[i].get() != null){					// while the cursor is not null
				Entry oldRowEntry = (Entry) row[i].get();	// Entry object holds the old row cursor data
				Entry e = new Entry(oldRowEntry.getColumn(), x*oldRowEntry.getEntry());	// create new entry object that has same column number as well as scalar mult of entry from the old row
				newrow.append(e);							// append the entry to the list
				row[i].moveNext();							// move the cursor to the next entry
			}
			smult.row[i] = newrow;							// set the new list's row equal to that new row
		}
		return smult;										// return the scalar mult matrix
	}

	/** adds a matrix with the current matrix
	@param takes the matrix M to be added to the current matrix
	@return returns a new matrix that is the sum of this matrix with M**/
	public Matrix add(Matrix M){
		Matrix add = new Matrix(size);						// create a new matrix object to hold matrix sum
		for (int i = 1; i <= size; i++){
			List newrow = new List();						// create a new list object (temporary) to hold each row
			row[i].moveFront();								// move cursor of this matrix to the front
			M.row[i].moveFront();							// move cursor of matrix M to the front (both cursors are now in the same place)
			while (row[i].get() != null && M.row[i].get() != null){	// while both cursors are not null
				Entry oldRow = (Entry) row[i].get();		// entry object for the old row's cursor data
				Entry argOldRow = (Entry) M.row[i].get();	// entry object for tha argument old row's cursor data
				if (oldRow.getColumn() == argOldRow.getColumn()){	// if both cursors have the same column
					Entry e = new Entry(oldRow.getColumn(), oldRow.getEntry()+argOldRow.getEntry());	// create a new entry object holding the column and sum of both entries
					newrow.append(e);						// append the entry to the temporary list object
					row[i].moveNext();						// move both cursors to the next position
					M.row[i].moveNext();
				}
				if (oldRow.getColumn() < argOldRow.getColumn()){	// if the column number on the first matrix is less than the M matrix
					Entry e = new Entry(oldRow.getColumn(), oldRow.getEntry());	// create a new entry object holding the column and the first matrix's entry
					newrow.append(e);						// append the entry to the temporary list object
					row[i].moveNext();						// move the first matrix's cursor to the next position
				}
				if (oldRow.getColumn() > argOldRow.getColumn()){	// if the column number on the first matrix is greater than the M matrix
					Entry e = new Entry(argOldRow.getColumn(), argOldRow.getEntry());	// create a new entry object holding the column and the M matrix's entry
					newrow.append(e);						// append the entry to the temporary list object
					M.row[i].moveNext();					// move the M matrix's cursor to the next position
				}
				
			}
			add.row[i] = newrow;							// set that row's list equal to the new list
		}
		return add;											// return the addition matrix
	}

	/** subtracts a matrix from this matrix
	@param takes the matrix M to be subtracted from this matrix
	@return returns a new matrix which is the difference between matrix M and this matrix **/
	public Matrix sub(Matrix M){
		Matrix sub = M.scalarMult(-1);						// set sub matrix to the -1 scalar mult of the M matrix 
		return add(sub);									// return the sub matrix (which is the sum of this and the sub matrix)
	}

	/** transposes this matrix
	@param takes no arguments
	@return returns a new matrix which is the transpose of this matrix **/
	public Matrix transpose(){
		Matrix tran = new Matrix(size);						// create new matrix to hold the transpose of the matrix
		for (int i = 1; i <= size; i++){
			row[i].moveFront();								// set cursor to front of row
			while(row[i].get() != null){					// while the cursor is not null
				Entry e = (Entry) row[i].get();				// new entry object that holds the node data stored at the cursor
				tran.changeEntry(e.getColumn(), i, e.getEntry());	// change entry to the new matrix, this time swapping the row and column data while keeping the entry (double) the same
			}
		}
		return tran;										// return the transpose entry
	}

	/** mulitpies a matrix with this one
	@param takes the argument matrix M 
	@return returns a new matrix that is the product of M and this matrix **/
	public Matrix mult(Matrix M){
		Matrix mult = new Matrix(size);						// create new matrix to hold the matrix product
		Matrix mTran = M.transpose();						// create new matrix to hold transpose matrix M (to turn its columns into rows)
		for (int i = 1; i <= size; i++){					// iterate through matrix's rows
			for (int counter = 1; counter <= size; counter++){	// iterate through M's columns
				double dotProd = dot(row[i], mTran.row[counter]);	// create a dot product variable to hold the value of the dot product of the matrix's row and matrix M's column
				if (dotProd != 0.0){						// if the dot product variable is not zero
					mult.changeEntry(i, counter, dotProd);	// add it to the corresponding position in the matrix
				}
			}
			
		}
		return mult;										// return the product matrix
	}


	// Other functions


	/** overrides object's toString() method
	@param takes no arguments
	@return returns a string of this matrix**/
	public String toString(){
		String line = "";									// string line holds all the strings of the matrix
		for (int i = 1; i <= size; i++){
			line = line.concat(i+": ");
			line = line.concat(row[i].toString()+"\n");				// iterate through the lists and concatenate the string to the original line
		}
		return line;										// return the line string
	}


	// private functions


	/** computes the vector dot product of two matrix rows
	@param takes list P as a row to be multiplied 
	@param takes list Q as a row to be multiplied 
	@return returns the double which is the dot product of the two rows **/
	private static double dot(List P, List Q){
		P.moveFront();										// move cursors from both lists to the front
		Q.moveFront();
		double dotSum = 0;									// variable to hold the sum for the dot product
		while (P.get() != null && Q.get() != null){			// while neither cursor is null
			Entry p = (Entry) P.get();						// create new entry objects to store the data found in each respective
			Entry q = (Entry) Q.get();						// cursor
			if (p.getColumn() == q.getColumn()){			// if the cursor "indices" match
				dotSum += (p.getEntry()*q.getEntry());		// multiply the entries together and add the product to the dotSum variable
				P.moveNext();								// move both cursors along
				Q.moveNext();
			}
			if (p.getColumn() < q.getColumn()){				// if the P cursor column is less than the Q cursor column
				P.moveNext();								// move the P cursor
			}
			if (p.getColumn() > q.getColumn()){				// if the P cursor column is greater than the Q cursor column
				Q.moveNext();								// move the Q cursor
			}
		}
		return dotSum;										// return the dot product of the lists
	}

	private class Entry{
		private int column;		// store the position for the entry
		private double entry;	// store the number for the entry

		// constructor
		private Entry(int j, double num){
			column = j;
			entry = num;
		}

		/** return the column
		@param takes no arguments
		@return returns the column int **/
		public int getColumn(){
			return column;
		}

		/** return the entry
		@param takes no arguments
		@return returns the entry double **/
		public double getEntry(){
			return entry;
		}

		/** return a string representation of the entry
		@param takes no arguments
		@return returns a string of the entry**/
		public String toString(){
			return "("+column+", "+entry+")";
		}

		/** return a boolean comparing the entries
		@param takes the argument of Object x
		@return returns true of Object x and the data in this entry are the same, false otherwise**/
		public boolean equals(Object x){
			boolean equal = false;
			if (x instanceof Entry){
				Entry e = (Entry)x;
				if (e.getColumn() == column && e.getEntry() == entry){
					equal = true;
				}
			}
			return equal;
		}
	}
}