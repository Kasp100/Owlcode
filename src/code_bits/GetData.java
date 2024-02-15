package code_bits;

import exceptions.ReferenceException;
import owlcode.BitOfCode;
import owlcode.LocalMemory;
import owly_data.OwlyData;
import owly_data.OwlyObject;

public class GetData extends BitOfCode {
	/** The identifier. May use dots to seperate objects. */
	private String identifier;
	public GetData(String identifier) {
		this.identifier = identifier;
	}
	
	@Override
	public OwlyData execute(LocalMemory localMemory, OwlyObject activeObject) {
		if(activeObject != null) {
			return activeObject.get(identifier, activeObject);
		}else {
			throw new ReferenceException("Unknown reference: " + identifier, "unknown reference");
		}
	}
}
