public class UndefinedCursorException extends RuntimeException{
	public UndefinedCursorException(){
		super("Can not perform operaton on undefined cursor.");
	}
}