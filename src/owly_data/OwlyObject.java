package owly_data;

import java.util.HashMap;

public class OwlyObject {
	public Classy instanceOf;
	
	private HashMap<String, OwlyObject> subObjects = new HashMap<>();
	private HashMap<String, Primitivey> variables = new HashMap<>();
	/** @return the value of the field associated to the given identifier, this can be either an object or a variable. */
	public Object get(String identifier) {
		Primitivey variable = variables.get(identifier);
		if(variable != null) return variable;
		return subObjects.get(identifier);
	}
}
