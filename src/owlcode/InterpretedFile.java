package owlcode;

import java.util.HashMap;

public class InterpretedFile {
	public String path;
	
	HashMap<String, Classy> classes = new HashMap<>();
	HashMap<String, OwlyFunction> functions = new HashMap<>();
}
