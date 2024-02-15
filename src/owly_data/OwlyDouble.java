package owly_data;

import owlcode.PrimitiveType;
import owlcode.Type;

public class OwlyDouble extends OwlyData {
	public double value;
	public OwlyDouble(double value) {
		this.value = value;
	}
	@Override
	public Type getType() {
		return new PrimitiveType(getClass());
	}
}
