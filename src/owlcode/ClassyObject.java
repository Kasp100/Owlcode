package owlcode;

import java.util.HashMap;

public class ClassyObject {
	public Classy instanceOf;
	
	private HashMap<String, ClassyObject> subObjects = new HashMap<>();
	/** Returns the object. */
	public ClassyObject get(String identifier, boolean requirePublicAccess) {
		return subObjects.get(identifier);
	}
}
