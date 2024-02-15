package code_bits;

import owlcode.BitOfCode;
import owlcode.LocalMemory;
import owly_data.OwlyData;
import owly_data.OwlyObject;

public class Assignment extends BitOfCode {
	private String left;
	private BitOfCode right;
	public Assignment(String left, BitOfCode right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public OwlyData execute(LocalMemory localMemory, OwlyObject activeObject) {
		localMemory.put(left, right.execute(localMemory, activeObject));
		return null;
	}
}
