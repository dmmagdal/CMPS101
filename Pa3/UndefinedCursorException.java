// UndefinedCursorException.java
// Diego Magdaleno
// dmmagdal
// pa1: creates an exception to be thrown in the event a cursor is null

public class UndefinedCursorException extends RuntimeException{
	public UndefinedCursorException(){
		super("Can not perform operaton on undefined cursor.");
	}
}