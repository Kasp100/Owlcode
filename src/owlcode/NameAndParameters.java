package owlcode;

public class NameAndParameters {
	private String name;
	private Class<?>[] parameters;
	public NameAndParameters(String name, Class<?>[] parameters) {
		this.name = name;
		this.parameters = parameters;
	}
	public String getName() {
		return name;
	}
	public Class<?>[] getParameters() {
		return parameters;
	}
}
