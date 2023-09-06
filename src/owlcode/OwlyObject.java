package owlcode;

import java.util.HashMap;

public class OwlyObject {
	public Classy instanceOf;
	
	private HashMap<String, OwlyObject> subObjects = new HashMap<>();
	private HashMap<String, Primitivey> variables = new HashMap<>();
	/** Returns the object. */
	public Object get(String identifier) {
		Primitivey variable = variables.get(identifier);
		if(variable != null) return variable;
		return subObjects.get(identifier);
	}
}
