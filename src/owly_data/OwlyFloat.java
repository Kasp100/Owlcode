package owly_data;

import owlcode.PrimitiveType;
import owlcode.Type;

public class OwlyFloat extends OwlyData {
	public float value;
	public OwlyFloat(float value) {
		this.value = value;
	}
	@Override
	public Type getType() {
		return new PrimitiveType(getClass());
	}
}
