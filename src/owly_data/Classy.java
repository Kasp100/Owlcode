package owly_data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import owlcode.BitOfCode;
import owlcode.Field;
import owlcode.FileInterpreter;
import owlcode.NameAndParameters;
import owlcode.Type;
import exceptions.SyntaxException;

public class Classy extends Type {
	private String className;
	private Field[] fields;
	private HashMap<NameAndParameters, BitOfCode[]> methods = new HashMap<>();
	
	public OwlyObject createInstance() {
		OwlyObject createdObject = new OwlyObject(this);
		return createdObject;
	}
	
	public Classy(FileInterpreter fileInterpreter) throws IOException, SyntaxException {
		super(false);
		
		String readClassName = fileInterpreter.readWord();
		if(FileInterpreter.checkClassName(readClassName)) {
			throw fileInterpreter.createSyntaxException("Class names have to start with an uppercase letter.", "class naming failure");
		}
		className = readClassName;
		boolean classClosed = false;
		
		ArrayList<Field> fields = new ArrayList<>();
		
		ArrayList<AccessModifier> accessModifiers = new ArrayList<>();
		Type type = null;
		
		while(!classClosed) {
			Object read = fileInterpreter.readAny();
			Class<? extends Object> classRead = read.getClass();
			if(classRead == String.class) {
				final String stringRead = (String) read;
				if(type == null) {
					if(read.equals("public")) {
						accessModifiers.add(AccessModifier.PUBLIC);
					}else if(read.equals("constant")) {
						accessModifiers.add(AccessModifier.CONSTANT);
					}else if(read.equals("void")) {
						type = new Voidy();
					}else if(FileInterpreter.checkClassName(stringRead)) {
						type = fileInterpreter.getClassFromImports(stringRead);
					}else {
						type = FileInterpreter.getPrimitiveClass(stringRead);
					}
				}else {
					
				}
			}else if(classRead == Character.class) {
				final char charRead = (char) read;
				if(charRead == '}') {
					classClosed = true;
				}
			}else if(classRead.isPrimitive()) {
				throw fileInterpreter.createSyntaxException("Found numeric/boolean value without context.", "unexpected numbers");
			}
		}
	}
	
	
	
	private enum AccessModifier {
		PUBLIC,
		CONSTANT,
	}
	
	public String getName() {
		return className;
	}
}
