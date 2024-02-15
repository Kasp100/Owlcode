package exceptions;

public class OwlyException extends Exception {
	private static final long serialVersionUID = 5274449433560378799L;
	
	static final String DOCUMENTATION_SITE_PREFIX = "documentation: ";
	public OwlyException(String type, String message, String documentationPage) {
		super("Oops! An exception occurred: (" + type + ") " + message + '\n' + "For more info, go to " + DOCUMENTATION_SITE_PREFIX + documentationPage);
	}
}
