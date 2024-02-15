package exceptions;

public class IllegalAccessException extends OwlyRuntimeException {
	private static final long serialVersionUID = -1355041614384353205L;
	public IllegalAccessException(String message, String documentationPage) {
		super(IllegalAccessException.class.getName(), message, documentationPage);
	}
	
}
