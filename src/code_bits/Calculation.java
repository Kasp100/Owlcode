package code_bits;

import owlcode.BitOfCode;
import owlcode.LocalMemory;
import owlcode.PrimitiveType;
import owly_data.OwlyBoolean;
import owly_data.OwlyData;
import owly_data.OwlyInt;
import owly_data.OwlyObject;

public class Calculation extends BitOfCode {
	private char operand;
	private BitOfCode[] numbers;
	public Calculation(char operand, BitOfCode[] numbers) {
		this.operand = operand;
		this.numbers = numbers;
	}
	
	@Override
	public OwlyData execute(LocalMemory localMemory, OwlyObject activeObject) {
		OwlyData[] calculatedNumbers = new OwlyData[numbers.length];
		PrimitiveType outputType = new PrimitiveType(OwlyInt.class);
		
		int index = 0;
		for(BitOfCode code : numbers) {
			OwlyData evaluated = code.execute(localMemory, activeObject);
			calculatedNumbers[index] = evaluated;
			
			PrimitiveType type = (PrimitiveType) evaluated.getType();
			if(!type.equals(outputType)) {
				outputType = outputType.getBiggest(type);
			}
			
			index++;
		}
		
		
	}
	
	public enum Operand {
		ADDITION,
		SUBTRACTION,
		MULTIPLICATION,
		DIVISION,
		MODULO,
		AND,
		OR,
		NOT,
	}
}
