package threadapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {

    public int read(String name) throws FileNotFoundException {
        int numberOfLines = 0;
        File file = new File(name + ".txt");
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNextLine()) {
            numberOfLines++;
            scanner.nextLine();
        }
        
        return numberOfLines;
    }
}
