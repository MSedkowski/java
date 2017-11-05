package charts.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChartData {

    private List<Integer> listOfLines;

    public ChartData(String name) throws IOException {
        this.listOfLines = new ArrayList<>();
        readChartData(name);
    }

    public void readChartData(String name) throws IOException {
        FileReader file = new FileReader("./logFiles/" + name);
        BufferedReader characterReader = new BufferedReader(file);
        int numberOfChars = 0;
        String data;
        while ((data = characterReader.readLine()) != null) {
            numberOfChars = data.length();
            addListOfLines(numberOfChars);
            numberOfChars = 0;
        }
    }

    public List<Integer> getListOfLines() {
        return listOfLines;
    }

    public void addListOfLines(Integer numberOfChars) {
        this.listOfLines.add(numberOfChars);
    }
}
