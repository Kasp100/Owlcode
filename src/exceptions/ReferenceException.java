package exceptions;

public class ReferenceException extends OwlyRuntimeException {
	private static final long serialVersionUID = 2387092073103510440L;
	public ReferenceException(String message, String documentationPage) {
		super(ReferenceException.class.getName(), message, documentationPage);
	}

}
