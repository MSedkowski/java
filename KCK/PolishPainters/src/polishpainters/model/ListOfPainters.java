
package polishpainters.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListOfPainters {
    private ObservableList<Painter> listOfPainters = FXCollections.observableArrayList();
    
    public void setListOfPainters(ObservableList<Painter> listOfPainters) {
        this.listOfPainters = listOfPainters;
    }

    public ObservableList<Painter> getListOfPainters() {
        return listOfPainters;
    }
    
    public void addPainter(Painter painter) {
        this.listOfPainters.add(painter);
    }
    
    public void removePainter(Painter painter) {
        this.listOfPainters.remove(painter);
    }
}
