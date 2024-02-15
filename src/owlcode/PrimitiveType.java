package owlcode;

import owly_data.OwlyBoolean;
import owly_data.OwlyInt;
import owly_data.OwlyLong;
import owly_data.OwlyObject;
import owly_data.OwlyFloat;
import owly_data.OwlyDouble;
import owly_data.OwlyData;

public class PrimitiveType extends Type {
	private Class<?> typeClass;
	public PrimitiveType(Class<?> typeClass) {
		this.typeClass = typeClass;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass().equals(PrimitiveType.class)) {
			PrimitiveType type = (PrimitiveType) obj;
			return typeClass == type.typeClass;
		}
		return obj == this;
	}
	public PrimitiveType getBiggest(PrimitiveType other) {
		return new PrimitiveType(getTypeClassForIndex(Math.max(getTypeIndex(), other.getTypeIndex())));
	}
	private int getTypeIndex() {
		if(typeClass == OwlyBoolean.class) {
			return 1;
		}else if(typeClass == OwlyInt.class) {
			return 2;
		}else if(typeClass == OwlyLong.class) {
			return 3;
		}else if(typeClass == OwlyFloat.class) {
			return 4;
		}else if(typeClass == OwlyDouble.class) {
			return 5;
		}else {
			return 0;
		}
	}
	private Class<? extends OwlyData> getTypeClassForIndex(int typeIndex){
		if(typeIndex == 1) {
			return OwlyBoolean.class;
		}else if(typeIndex == 2) {
			return OwlyInt.class;
		}else if(typeIndex == 3) {
			return OwlyLong.class;
		}else if(typeIndex == 4) {
			return OwlyFloat.class;
		}else if(typeIndex == 5) {
			return OwlyDouble.class;
		}else {
			return OwlyObject.class;
		}
	}
}
