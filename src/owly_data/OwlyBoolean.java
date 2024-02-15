package owly_data;

import owlcode.PrimitiveType;
import owlcode.Type;

public class OwlyBoolean extends OwlyData {
	public boolean value;
	public OwlyBoolean(boolean value) {
		this.value = value;
	}
	@Override
	public Type getType() {
		return new PrimitiveType(getClass());
	}
}
