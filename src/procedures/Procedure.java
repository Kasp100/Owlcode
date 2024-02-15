package procedures;

import owlcode.BitOfCode;
import owlcode.LocalMemory;
import owly_data.OwlyData;
import owly_data.OwlyObject;

public class Procedure {
	private String[] parameterNames;
	private BitOfCode[] bitsOfCode;
	public Procedure(String[] parameterNames, BitOfCode[] bitsOfCode) {
		this.parameterNames = parameterNames;
		this.bitsOfCode = bitsOfCode;
	}
	
	public OwlyData run(OwlyData[] parameterValues, OwlyObject receivingObject) {
		LocalMemory localMemory = new LocalMemory();
		
		int index = 0;
		for(OwlyData parameterValue : parameterValues) {
			localMemory.put(parameterNames[index], parameterValue);
			index++;
		}
		 
		for(BitOfCode bitOfCode : bitsOfCode) {
			bitOfCode.execute(localMemory, receivingObject);
		}
		return null;
	}
}
