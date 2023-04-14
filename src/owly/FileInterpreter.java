package owly;

import java.io.File;

public class FileInterpreter {
	static String rootFileAddress;
	public Classy[] interpretFile(String fileName) {
		File readFile = new File(rootFileAddress + File.separator + fileName + ".owl");
	}
}
