package owlcode;

import java.util.LinkedHashMap;

import owly_data.OwlyObject;
import owly_data.Primitivey;

public class ExecutionContext {
	LinkedHashMap<String, OwlyObject> localObjects = new LinkedHashMap<>();
	LinkedHashMap<String, Primitivey> localVariables = new LinkedHashMap<>();
}
