import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class DuplicateRemover {
	
	private Set<String> uniqueWords = new HashSet<String>();
	
	public void remove(String dataFile) {
		
		try (Scanner fileScanner = new Scanner(new File(dataFile))) {
			while (fileScanner.hasNextLine()) {
				String word = fileScanner.next();
				word = word.toLowerCase();
				word = word.replaceAll("\\p{Punct}", "");
				uniqueWords.add(word);
			}
		
		} catch (FileNotFoundException e) {
			System.out.println("Error: Exceptional IO Event\nProgram exiting.");
			System.exit(0);
		}
		
	}
	
	public void write(String outputFile) {
		
		try (Writer fileWriter = new PrintWriter(new File(outputFile))) {
			for (String word: uniqueWords) {
				fileWriter.write(word);
				fileWriter.write("\n");
			}
		} catch (IOException e) {
			System.out.println("Error: Exceptional IO Event\nProgram exiting.");
			System.exit(0);
		}
	}
	
	
}
