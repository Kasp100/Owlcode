package exceptions;

public class OwlyRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 8688317241398020225L;
	public OwlyRuntimeException(String type, String message, String documentationPage) {
		super("My bad! A runtime exception occurred: (" + type + ")" + message + '\n' + "For more info, go to " + OwlyException.DOCUMENTATION_SITE_PREFIX + documentationPage);
	}
}
