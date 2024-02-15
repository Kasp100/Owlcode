package owly_data;

import java.util.HashMap;

public class OwlyObject {
	private Classy instanceOf;
	
	private HashMap<String, Object> state = new HashMap<>();
	
	public OwlyObject(Classy classy) {
		
	}
	
	/** @return the value of the field associated to the given identifier, this can be either an object or a variable. */
	public Object get(String identifier) {
		return state.get(identifier);
	}
	public Classy getClassy() {
		return instanceOf;
	}
}
