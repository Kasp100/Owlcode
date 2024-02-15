package owly_data;

import owlcode.PrimitiveType;
import owlcode.Type;

public class OwlyInt extends OwlyData {
	public int value;
	public OwlyInt(int value) {
		this.value = value;
	}
	@Override
	public Type getType() {
		return new PrimitiveType(getClass());
	}
}
