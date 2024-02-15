package owlcode;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import exceptions.SyntaxException;
import owly_data.Classy;
import owly_data.OwlyDouble;
import owly_data.OwlyFloat;
import owly_data.OwlyInt;
import owly_data.OwlyLong;

public class FileInterpreter {
	private static final String LETTERS = "_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final String DIGITS = "0123456789";
	
	private static String rootFileAddress;
	private File fileToRead;
	private InputStreamReader fileReader;
	private int lastCharRead;
	private int charsRead, linesRead, charsReadInLine;
	private boolean nextCharRead = false;
	public InterpretedFile interpretFile(String fileName) throws IOException, SyntaxException, SyntaxException {
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
				Classy createdClass = new Classy(this);
				interpretedFile.classes.put(createdClass.getName(), createdClass);
			}else if(word.equals("function")) {
				
			}else {
				throw new SyntaxException("Unexpected word", charsRead, linesRead, charsReadInLine,
						"file: " + fileToRead.getAbsolutePath(), "unexpected words");
			}
			
		} while (word != null);
		
		return interpretedFile;
	}
	
	private void readChar() throws IOException {
		if(nextCharRead) {
			nextCharRead = false;
			return;
		}
		lastCharRead = fileReader.read();
		charsRead++;
		if(lastCharRead == '\n') {
			linesRead++;
			charsReadInLine = 0;
		}
	}
	
	public void flagLastAsUnread() {
		nextCharRead = true;
	}
	
	public Object readAny() throws IOException, SyntaxException {
		readChar();
		
		if(lastCharRead == -1) {
			throw createSyntaxException("File ends abruptly.", "abrupt end of file");
		}
		
		char read = getCharRead();
		if(DIGITS.contains("" + read) || read == '-') {
			flagLastAsUnread();
			return readNumber();
		}else if(LETTERS.contains("" + read)) {
			flagLastAsUnread();
			return readWord();
		}
		return read;
	}
	
	private char getCharRead() {
		return (char) lastCharRead;
	}
	
	public String readWord() throws IOException {
		boolean readingWord = false;
		StringBuilder wordBuilder = new StringBuilder();
		
		do {
			readChar(); 
			if(lastCharRead != -1) {
				
				final String lastCharAsString = "" + getCharRead();
				boolean isLetter = LETTERS.contains(lastCharAsString);
				boolean isSpace = lastCharAsString.isBlank();
				
				if(readingWord) {
					
					if(isLetter) {
						wordBuilder.append(lastCharAsString);
					}else {
						String word = wordBuilder.toString();
						wordBuilder = new StringBuilder();
						return word;
					}
					
				}else {
					if(isLetter) {
						wordBuilder.append(lastCharAsString);
						readingWord = true;
					}else if(!isSpace) {
						return null;
					}
				}
			}
		} while (lastCharRead != -1);
		return null;
	}
	
	private Object readNumber() throws IOException, SyntaxException {
		boolean hasFractionalPart = false;
		StringBuilder numberBuilder = new StringBuilder();
		
		String read;
		boolean validPartOfNumber;
		do{
			validPartOfNumber = false;
			
			readChar();
			read = getCharRead() + "";
			if(lastCharRead == -1) throw createSyntaxException("File ends abruptly whilest reading a number.", "abrupt end of file");
			if(DIGITS.contains(read) || read.equals("_")) {
				validPartOfNumber = true;
			}else if(read.equals(".")) {
				validPartOfNumber = true;
			}
			
		}while(validPartOfNumber);
		
		try {
			if(getCharRead() == 'B') {
				if(hasFractionalPart) {
					return new OwlyDouble(Double.parseDouble(numberBuilder.toString()));
				}else {
					return new OwlyLong(Long.parseLong(numberBuilder.toString()));
				}
			}else {
				nextCharRead = true;
			}
			
			if(hasFractionalPart) {
				return new OwlyFloat(Float.parseFloat(numberBuilder.toString()));
			}
			
			return new OwlyInt(Integer.parseInt(numberBuilder.toString()));
		} catch (NumberFormatException e) {
			throw createSyntaxException(e.getClass().getName() + ": " + e.getMessage(), "number format exception");
		}
	}
	
	public SyntaxException createSyntaxException(String message, String docPage) {
		return new SyntaxException(message, charsRead, linesRead, charsReadInLine,
				"file: " + fileToRead.getAbsolutePath(), docPage);
	}
}
