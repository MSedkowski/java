
package webreaderapplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {
    private String fileName;
    SaveToFile() {
        this.fileName = "Output";
    }

    SaveToFile(String fileName) {
        this.fileName = fileName;
    }
    
    public void save(String data) throws IOException {
        FileWriter newFile = new FileWriter((fileName + ".txt"), true);
        BufferedWriter buffer = new BufferedWriter(newFile);
        if (data != null) buffer.write(data + System.getProperty("line.separator"));
        buffer.close();
    }
}
