package lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class WordCounter {
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("story.txt");
        Scanner scanner = new Scanner(file);
        int wordCount;

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            wordCount = 0;
            Scanner scnr = new Scanner(line);
            while(scnr.hasNext()){
                scnr.next();
                wordCount++;
            }
            System.out.println("Line has " + wordCount + " words.");
        }

    }
}
