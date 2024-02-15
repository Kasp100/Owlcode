package owlcode;

import java.util.HashMap;

import owly_data.Classy;
import procedures.Procedure;

public class InterpretedFile {
	public String path;

	public HashMap<String, Classy> importedClasses = new HashMap<>();
	public HashMap<String, Procedure> importedFunctions = new HashMap<>();
	public HashMap<String, Classy> classes = new HashMap<>();
	public HashMap<String, Procedure> functions = new HashMap<>();
}
