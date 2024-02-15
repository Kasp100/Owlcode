package code_bits;

import owlcode.BitOfCode;
import owlcode.LocalMemory;
import owly_data.OwlyData;
import owly_data.OwlyObject;
import procedures.Function;
import procedures.Procedure;

public class ProcedureCall extends BitOfCode {
	private Procedure procedure;
	private BitOfCode[] parameters;
	public ProcedureCall(Procedure procedure, BitOfCode[] parameters) {
		this.procedure = procedure;
		this.parameters = parameters;
	}
	
	@Override
	public OwlyData execute(LocalMemory localMemory, OwlyObject activeObject) {
		OwlyData[] parameterValues = new OwlyData[parameters.length];
		for (int i = 0; i < parameterValues.length; i++) {
			parameterValues[i] = parameters[i].execute(localMemory, activeObject);
		}
		
		if(procedure.getClass() == Function.class) {
			return ((Function) procedure).run(parameterValues);
		}else {
			return procedure.run(parameterValues, activeObject);
		}
	}
}
