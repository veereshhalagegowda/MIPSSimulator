package ConfigParser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ConfigParser {
	
	//clock cycles for functional units
	public static int adderClockCycle = 0;
	public static int multiplierClockCycle = 0;
	public static int dividerCockCycle = 0;
	public static int memoryClockCycle = 0;
	public static int iCacheClockCycle = 0;
	public static int dCacheClockCycle = 0;
	
	//variables to store whether the functional units are pipelined
	public static boolean isAdderPipelined = false;
	public static boolean isMultiplierPipelined = false;
	public static boolean isDividerPipelined = false;
	
	
	
	public void parseConfig(String fileName)
			throws FileNotFoundException, IOException {
		
		FileReader file = null;
		String line;
		Scanner scanner = null;
		try {
			scanner = new Scanner(getClass().getResourceAsStream(fileName));
			while (scanner.hasNext()) {
				line = scanner.nextLine();
				parseConfigurationFile(line);
			}
		}
		finally {
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
	public void parseConfigurationFile(String line) {
		String s[];
		line = line.replace(',', ':');
		s = line.split(":");

		for (int i = 0; i < s.length; i++) {
			String key = s[i].trim().toUpperCase();

			switch (key) {
			case "FP ADDER":
				i++;
				adderClockCycle = Integer.parseInt(s[i].trim());
				i++;
				s[i] = s[i].trim();
				isAdderPipelined = s[i].equalsIgnoreCase("yes");

				break;

			case "FP MULTIPLIER":
				i++;
				multiplierClockCycle = Integer.parseInt(s[i].trim());
				i++;
				s[i] = s[i].trim();
				isMultiplierPipelined = s[i].equalsIgnoreCase("yes");
				break;

			case "FP DIVIDER":
				i++;
				dividerCockCycle = Integer.parseInt(s[i].trim());
				i++;
				s[i] = s[i].trim();
				isDividerPipelined = s[i].equalsIgnoreCase("yes");
				break;

			case "MAIN MEMORY":
				i++;
				memoryClockCycle = Integer.parseInt(s[i].trim());
				break;
			
			case "I-CACHE":
				i++;
				iCacheClockCycle = Integer.parseInt(s[i].trim());
				break;

			case "D-CACHE":
				i++;
				dCacheClockCycle = Integer.parseInt(s[i].trim());
				break;
			
			default:
				break;
			}
		}
	}
}
