package owlcode;

public class Field {
	private Class<?> type;
	private boolean constant;
	private boolean publicAccess;
	public Field(Class<?> type, boolean constant, boolean publicAccess) {
		this.type = type;
		this.publicAccess = publicAccess;
		this.constant = constant;
		this.publicAccess = publicAccess;
	}
	public Class<?> getType() {
		return type;
	}
	public boolean isConstant() {
		return constant;
	}
	public boolean isPublic() {
		return publicAccess;
	}
}
