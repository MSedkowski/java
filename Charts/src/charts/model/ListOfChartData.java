
package charts.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListOfChartData {
    private ObservableList<ChartData> listOfChartData = FXCollections.observableArrayList();
    
    public void setListOfChartData(ObservableList<ChartData> listOfChartData) {
        this.listOfChartData = listOfChartData;
    }

    public ObservableList<ChartData> getListOfChartData() {
        return listOfChartData;
    }
    
    public void addChartData(ChartData chartData) {
        this.listOfChartData.add(chartData);
    }
    
    public void removeChartData(ChartData chartData) {
        this.listOfChartData.remove(chartData);
    }
}
