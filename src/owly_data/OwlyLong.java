package owly_data;

import owlcode.PrimitiveType;
import owlcode.Type;

public class OwlyLong extends OwlyData {
	public long value;
	public OwlyLong(long value) {
		this.value = value;
	}
	@Override
	public Type getType() {
		return new PrimitiveType(getClass());
	}
}
