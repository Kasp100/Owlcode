package owlcode;

public class Field {
	private String fieldName;
	private Class<?> type;
	private boolean constant;
	private boolean publicAccess;
	public Field(String fieldName, Class<?> type, boolean constant, boolean publicAccess) {
		this.fieldName = fieldName;
		this.type = type;
		this.publicAccess = publicAccess;
		this.constant = constant;
		this.publicAccess = publicAccess;
	}
	
	public String getName() {
		return fieldName;
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
