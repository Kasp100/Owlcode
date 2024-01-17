package owlcode;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import exceptions.SyntaxException;

public class FileInterpreter {
	static final String LETTERS = "_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	static String rootFileAddress;
	File fileToRead;
	InputStreamReader fileReader;
	private int lastCharRead;
	int charsRead, linesRead, charsReadInLine;
	public InterpretedFile interpretFile(String fileName) throws IOException, SyntaxException {
		fileToRead = new File(rootFileAddress + File.separator + fileName + ".owl");
		fileReader = new FileReader(fileToRead, StandardCharsets.UTF_8);
		
		InterpretedFile interpretedFile = new InterpretedFile();
		
		String word;
		do {
			word = readWord();
			
			if(word == null) {
				throw new SyntaxException("Unexpected character", charsRead, linesRead, charsReadInLine,
						"file: " + fileToRead.getAbsolutePath(), "unexpected characters");
			}else if(word.equals("class")) {
				
			}else if(word.equals("function")) {
				
			}else {
				throw new SyntaxException("Unexpected word", charsRead, linesRead, charsReadInLine,
						"file: " + fileToRead.getAbsolutePath(), "unexpected words");
			}
			
		} while (word != null);
		
		return interpretedFile;
	}
	
	public void readChar() throws IOException {
		lastCharRead = fileReader.read();
		charsRead++;
		if(lastCharRead == '\n') {
			++linesRead;
			charsReadInLine = 0;
		}
	}
	
	public String readWord() throws IOException {
		boolean readingWord = false;
		StringBuilder wordBuilder = new StringBuilder();
		
		do {
			readChar(); 
			if(lastCharRead != -1) {
				
				final String lastCharAsString = lastCharRead + "";
				boolean isLetter = LETTERS.contains(lastCharAsString);
				boolean isSpace = lastCharAsString.isBlank();
				
				if(readingWord) {
					
					if(isLetter) {
						wordBuilder.append(lastCharRead);
					}else {
						String word = wordBuilder.toString();
						wordBuilder = new StringBuilder();
						return word;
					}
					
				}else {
					if(isLetter) {
						wordBuilder.append(lastCharRead);
						readingWord = true;
					}else if(!isSpace) {
						return null;
					}
				}
			}
		} while (lastCharRead != -1);
		return null;
	}
	
	public static WordMeaning getMeaning(String word) {
		if(word.equals("if") || word.equals("while") || word.equals("for")
				|| word.equals("else")|| word.equals("return")) {
			return WordMeaning.KEYWORD;
		}else if(word.equals("null")) {
			return WordMeaning.NULL;
		}else if(word.equals("int") || word.equals("long") || word.equals("boolean")
				|| word.equals("float")|| word.equals("double")) {
			return WordMeaning.PRIMITIVE;
		}else if(Character.isUpperCase(word.charAt(0))) {
			return WordMeaning.CLASS;
		}else {
			return WordMeaning.NAME;
		}
	}
	
	public enum WordMeaning {
		KEYWORD,
		NULL,
		PRIMITIVE,
		CLASS,
		NAME,
	}
}
