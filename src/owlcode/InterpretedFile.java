package owlcode;

import java.util.HashMap;

import owly_data.Classy;
import owly_data.OwlyFunction;

public class InterpretedFile {
	public String path;

	public HashMap<String, Classy> importedClasses = new HashMap<>();
	public HashMap<String, OwlyFunction> importedFunctions = new HashMap<>();
	public HashMap<String, Classy> classes = new HashMap<>();
	public HashMap<String, OwlyFunction> functions = new HashMap<>();
}
