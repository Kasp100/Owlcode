package owlcode;

import java.util.HashMap;

import owly_data.Classy;
import owly_data.OwlyFunction;

public class InterpretedFile {
	public String path;
	
	HashMap<String, Classy> classes = new HashMap<>();
	HashMap<String, OwlyFunction> functions = new HashMap<>();
}
