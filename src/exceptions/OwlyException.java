package exceptions;

public class OwlyException extends Exception {
	private static final long serialVersionUID = 5274449433560378799L;
	
	static final String DOCUMENTATION_SITE_PREFIX = "";
	public OwlyException(String message, String documentationPage) {
		super(message + '\n' + "For more info, access " + DOCUMENTATION_SITE_PREFIX + documentationPage);
	}
}
