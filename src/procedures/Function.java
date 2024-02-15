package procedures;

import owlcode.BitOfCode;
import owly_data.OwlyData;

public class Function extends Procedure {

	public Function(String[] parameterNames, BitOfCode[] bitsOfCode) {
		super(parameterNames, bitsOfCode);
	}
	
	public OwlyData run(OwlyData[] parameterValues) {
		return super.run(parameterValues, null);
	}
}
