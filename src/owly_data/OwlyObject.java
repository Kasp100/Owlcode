package owly_data;

import java.util.HashMap;
import java.util.regex.Pattern;

import exceptions.IllegalAccessException;

public class OwlyObject extends OwlyData {
	private Classy instanceOf;
	
	private HashMap<String, OwlyData> state = new HashMap<>();
	
	public OwlyObject(Classy classy) {
		
	}
	
	/** Uses the identifier to look for data within this object. The identifier can be a series of subobjects separated by a dot.
	 *  @return the value of the field associated to the given identifier, this can be either an object or a variable. 
	 * @throws IllegalAccessException when trying to access a private field. */
	public OwlyData get(String identifier, OwlyObject requester) {
		if(identifier.contains(".")) {
			final String[] parts = identifier.split(Pattern.quote("."));
			final String firstIdentifier = parts[0];
			final OwlyObject object = (OwlyObject) tryGet(firstIdentifier, requester);
			return object.get(identifier.substring(firstIdentifier.length() + 1), this);
		}else {
			return tryGet(identifier, requester);
		}
	}
	private OwlyData tryGet(String identifier, OwlyObject requester) {
		OwlyData data = state.get(identifier);
		if(requester == this || !instanceOf.getField(identifier).isPublic()) {
			return data;
		}else {
			throw new IllegalAccessException("Accessing private field " + identifier + " from " + requester.instanceOf.getName() + " requires public access.",
					"reading from private field");
		}
	}
	
	public Classy getClassy() {
		return instanceOf;
	}
}
