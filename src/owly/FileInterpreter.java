package owly;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import exceptions.SyntaxException;

public class FileInterpreter {
	static String rootFileAddress;
	File fileToRead;
	InputStreamReader fileReader;
	private int lastCharRead;
	int charsRead, linesRead, charsReadInLine;
	public void interpretFile(String fileName) throws IOException, SyntaxException {
		fileToRead = new File(rootFileAddress + File.separator + fileName + ".owl");
		fileReader = new FileReader(fileToRead, StandardCharsets.UTF_8);
		
		String word;
		do {
			word = readWord();
			
			if(word == null) {
				throw new SyntaxException("Unexpected character", charsRead, linesRead, charsReadInLine,
						"file: " + fileToRead.getAbsolutePath(), "unexpected characters");
			}else if(word.equals("template")) {
				
			}else {
				throw new SyntaxException("Unexpected word", charsRead, linesRead, charsReadInLine,
						"file: " + fileToRead.getAbsolutePath(), "unexpected words");
			}
			
		} while (word != null);
		
		// TODO: return Classy[]
	}
	
	void readChar() throws IOException {
		lastCharRead = fileReader.read();
		charsRead++;
		if(lastCharRead == '\n') {
			++linesRead;
			charsReadInLine = 0;
		}
	}
	
	String readWord() throws IOException {
		boolean readingWord = false;
		StringBuilder wordBuilder = new StringBuilder();
		
		do {
			readChar(); 
			if(lastCharRead != -1) {
				
				boolean isLetter = ("_abcdefghijklmnopqrstuvwxyz0123456789").contains((lastCharRead + "").toLowerCase());
				boolean isSpace = ("" + lastCharRead).isBlank();
				
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
}
