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
	
	public void count (String dataFile) {
		
		try (Scanner sc = new Scanner(new File(dataFile))) {
			
			while (sc.hasNextLine()) {
				
				String word = sc.next();
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
			System.out.println("Error: program exiting");
			System.exit(0);
		}
		
	}
	
	public void write (String outputFile) {
		
		
		try (Writer write = new PrintWriter(new File(outputFile))) {
			
			
			for (String key : wordCounter.keySet()) {
				write.write(key + " " + wordCounter.get(key) + "\n");
			
			}
			
		} catch (IOException e) {
			System.out.println("Error: program exiting.");
			System.exit(0);
		}
	}
}
