package MemoryParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;


public class MemoryParser {
	//importing data from data.txt
	public int dataWordsSize = 0;
	
	Map<Integer, Integer> dataValues = new HashMap<Integer, Integer>();
	Map<Integer, Integer> registerData = new HashMap<Integer, Integer>();
	
	// Information about the data in registers from reg.txt 
	public int registerDataSize = 0;
	
	//binary to decimal conversion
	public void convertBinaryToDecimal(String line, boolean isMemorydata) {
		if (isMemorydata) {
			dataValues.put(dataWordsSize, Integer.parseInt(line, 2));
			dataWordsSize++;
		} else {
			registerData.put(registerDataSize, Integer.parseInt(line, 2));
			registerDataSize++;
		}
	}
	
	
	public void parse(String fileName, boolean isDataFile)
			throws FileNotFoundException, IOException {

		FileReader file = null;
		String line;
		Scanner scanner = null;
		try {
			scanner = new Scanner(getClass().getResourceAsStream(fileName));
			while (scanner.hasNext()) {
				line = scanner.nextLine();
				
					convertBinaryToDecimal(line, isDataFile);
				}

		} finally {
			if (file != null) {
				try {
					file.close();
					scanner.close();
				} catch (IOException e) {
					throw new RuntimeException("IO error");
				}
			}
		}
	}
}
