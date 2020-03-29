import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
	
	private Map<String, Integer> wordCounter = new HashMap<String, Integer>();
	
	public void count(String dataFile) {
		
		try (Scanner fileScanner = new Scanner(new File(dataFile))) {
			
			while (fileScanner.hasNextLine()) {
				
				String word = fileScanner.next();
				word = word.toLowerCase();
				word = word.replaceAll("\\p{Punct}", "");
				
				if (wordCounter.containsKey(word)) {
					wordCounter.replace(word, wordCounter.get(word)+1);
				} 
				else {
					wordCounter.put(word, 1);
				}
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error: Exceptional IO Event\nProgram exiting.");
			System.exit(0);
		}
		
	}
	
	public void write(String outputFile) {
		
		
		try (Writer fileWriter = new PrintWriter(new File(outputFile))) {
			
			
			for (String key : wordCounter.keySet()) {
				fileWriter.write(key + " " + wordCounter.get(key) + "\n");
			
			}
			
		} catch (IOException e) {
			System.out.println("Error: Exceptional IO Event\nProgram exiting.");
			System.exit(0);
		}
	}
}
