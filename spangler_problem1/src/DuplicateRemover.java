import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class DuplicateRemover {
	
	Set<String> uniqueWords = new HashSet<String>();
	
	public void remove(String dataFile) {
		
		File input = new File(dataFile);
		
		try (Scanner sc = new Scanner(input)) {
			while (sc.hasNextLine()) {
				String word = sc.next();
				word = word.toLowerCase();
				word = word.replaceAll("\\p{Punct}", "");
				uniqueWords.add(word);
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void write(String outputFile) {
		
		File output = new File(outputFile);
		
		try (Writer write = new PrintWriter(output)) {
			for (String word: uniqueWords) {
				write.write(word);
				write.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
