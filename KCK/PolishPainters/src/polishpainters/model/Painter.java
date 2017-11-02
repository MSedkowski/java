package polishpainters.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Painter {

    private String painterName;
    private String painterBirthDate;
    private List<Painting> listOfPaintings;

    public Painter() {
        this.painterName = null;
        this.painterBirthDate = null;
        this.listOfPaintings = new ArrayList<>();
    }

    public Painter(String name) throws FileNotFoundException, IOException {
        this.listOfPaintings = new ArrayList<>();
        readPainterDataFromFile(name);
    }

    private void readPainterDataFromFile(String filename) throws FileNotFoundException, IOException {
        FileReader file = new FileReader("./painters/" + filename);
        BufferedReader buffer = new BufferedReader(file);
        setPainterName(buffer.readLine().replace("&nbsp;", ""));
        setPainterBirthDate(buffer.readLine());
        String painting = null;
        while ((painting = buffer.readLine()) != null) {
            Painting paintingDetails = new Painting();
            String[] details = painting.split("\t");
            String[] details2 = details[2].split("\\. ");
            paintingDetails.setFileSource(details[0].replace("\"", "").trim());
            paintingDetails.setPaintingName(details[1].replace("\"", "").trim());
            if (details2[0] != null) {
            paintingDetails.setPaintingData(details[2].replace(details2[details2.length - 1], "").trim());
            paintingDetails.setPaintingLocation(details2[details2.length - 1].trim().replace("\"", ""));
            }
            else {
                 paintingDetails.setPaintingData(details[2].replace("\"", "").trim());
                 paintingDetails.setPaintingLocation("Lokacja nieznana");
            }
            addListOfPaintings(paintingDetails);
        }
    }

    public String getPainterName() {
        return painterName;
    }

    public String getPainterBirthDate() {
        return painterBirthDate;
    }

    public List<Painting> getListOfPaintings() {
        return listOfPaintings;
    }
    
    public void setPainterName(String name) {
        this.painterName = name;
    }
    
    public void setPainterBirthDate(String birth) {
        this.painterBirthDate = birth;
    }
    
    public void addListOfPaintings(Painting paintingDetails) {
        this.listOfPaintings.add(paintingDetails);
    }
}
