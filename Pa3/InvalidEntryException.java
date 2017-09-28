// InvalidEntryExcpetion.java
// Diego Magdaleno
// dmmagdal
// Pa3: creates an exception to be thrown in the event an entry is made outside of the matrix parameters

public class InvalidEntryException extends RuntimeException{
	public InvalidEntryException(){
		super("Can not insert entry outside of matrix.");
	}
}
