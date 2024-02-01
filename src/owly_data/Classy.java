package owly_data;

import java.io.IOException;

import owlcode.FileInterpreter;
import owlcode.FileInterpreter.WordMeaning;
import exceptions.SyntaxException;

public class Classy {
	public String className;
	
	public OwlyObject createInstance() {
		OwlyObject createdObject = new OwlyObject();
		createdObject.instanceOf = this;
		return createdObject;
	}
	
	public Classy(FileInterpreter fileInterpreter) throws IOException, SyntaxException {
		String readClassName = fileInterpreter.readWord();
		if(FileInterpreter.getMeaning(readClassName) != WordMeaning.CLASS) {
			throw fileInterpreter.createSyntaxException("Class names cannot be keywords and have to start with an uppercase letter.", "class naming failure");
		}
		className = readClassName;
		
		while(true) {
			Object read = fileInterpreter.readAny();
			Class<? extends Object> classRead = read.getClass();
			if(classRead == String.class) {
				
			}else if(classRead.getSuperclass() == Primitivey.class) {
				
			}
		}
	}
}
