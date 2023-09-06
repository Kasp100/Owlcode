package owlcode;

import java.util.LinkedHashMap;

public class ExecutionContext {
	LinkedHashMap<String, OwlyObject> localObjects = new LinkedHashMap<>();
	LinkedHashMap<String, Primitivey> localVariables = new LinkedHashMap<>();
}
