package owly_data;

import java.io.IOException;

import owlcode.Field;
import owlcode.FileInterpreter;
import exceptions.SyntaxException;

public class Classy {
	private String className;
	private Field[] fields;
	
	public OwlyObject createInstance() {
		OwlyObject createdObject = new OwlyObject(this);
		return createdObject;
	}
	
	public Classy(FileInterpreter fileInterpreter) throws IOException, SyntaxException {
		String readClassName = fileInterpreter.readWord();
		if(checkClassName(readClassName)) {
			throw fileInterpreter.createSyntaxException("Class names have to start with an uppercase letter.", "class naming failure");
		}
		className = readClassName;
		boolean classClosed = false;
		
		while(!classClosed) {
			Object read = fileInterpreter.readAny();
			Class<? extends Object> classRead = read.getClass();
			if(classRead == String.class) {
				if(checkClassName("")) {
					
				}
			}else if(classRead == Character.class) {
				char charRead = (char) read;
				if(charRead == '}') {
					classClosed = true;
				}
			}else if(classRead.getSuperclass() == Primitivey.class) {
				throw fileInterpreter.createSyntaxException("Found numeric value without context.", "unexpected numbers");
			}
		}
	}
	
	private boolean checkClassName(final String classNameRead) {
		return Character.isUpperCase(classNameRead.charAt(0));
	}
	
	public String getName() {
		return className;
	}
}
