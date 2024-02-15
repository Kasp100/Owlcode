package exceptions;

public class SyntaxException extends OwlyException {
	private static final long serialVersionUID = -2157114152936866288L;
	public SyntaxException(String message, int charsRead, int linesRead, int charsReadInLine,
			String documentSource, String documentationPage) {
		super(SyntaxException.class.getName(), message + "\n\t" + "at line " + (linesRead + 1) + ", position " + (charsReadInLine + 1)
				+ " (index: " + charsRead + ")" + "\n\t" + "reading " + documentSource, documentationPage);
	}
}
