package charts.view;

import charts.Charts;
import charts.model.ChartData;
import charts.model.ListOfChartData;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class BasicViewController {

    @FXML
    private RadioButton lineChartButton;
    @FXML
    private RadioButton scatterChartButton;
    @FXML
    private RadioButton barChartButton;
    @FXML
    private ScatterChart scatterChart;
    @FXML
    private LineChart<String, Integer> lineChart;
    @FXML
    private BarChart barChart;
    @FXML
    private ToggleGroup chartType;

    private ListOfChartData listOfChartData;

    @FXML
    public void initialize() {
        scatterChartButton.setSelected(true);
        
    }

    public void setMainApp(Charts main, ListOfChartData listOfChartData) {
        this.listOfChartData = listOfChartData;
        createScatterChart();
        createLineChart();
        createBarChart();
        showChart();
    }

    private void showChart() {
        if (chartType.getSelectedToggle().equals(scatterChartButton)) {
            lineChart.setVisible(false);
            barChart.setVisible(false);
            scatterChart.setVisible(true);
        }
        else if (chartType.getSelectedToggle().equals(lineChartButton)) {
            scatterChart.setVisible(false);
            barChart.setVisible(false);
            lineChart.setVisible(true);
        }
        else if (chartType.getSelectedToggle().equals(barChartButton)) {
            lineChart.setVisible(false);
            scatterChart.setVisible(false);
            barChart.setVisible(true);
        }
   }
    private void createLineChart() {
        int numberOfSeries = 1;
        for (ChartData e : listOfChartData.getListOfChartData()) {
        XYChart.Series<String, Integer> series = createChartDataSeries(e, numberOfSeries);
        lineChart.getData().add(series);
        numberOfSeries++;
        }
        lineChart.getXAxis().setLabel("Numer linii");
        lineChart.getYAxis().setLabel("Ilość znaków");

    }
    
    private void createBarChart() {
        int numberOfSeries = 1;
        for (ChartData e : listOfChartData.getListOfChartData()) {
        XYChart.Series<String, Integer> series = createChartDataSeries(e, numberOfSeries);
        barChart.getData().add(series);
        numberOfSeries++;
        }
        barChart.getXAxis().setLabel("Numer linii");
        barChart.getYAxis().setLabel("Ilość znaków");

    }
    
    private void createScatterChart() {
        int numberOfSeries = 1;
        for (ChartData e : listOfChartData.getListOfChartData()) {
        XYChart.Series<String, Integer> series = createChartDataSeries(e, numberOfSeries);
        scatterChart.getData().add(series);
        numberOfSeries++;
        }
        scatterChart.getXAxis().setLabel("Numer linii");
        scatterChart.getYAxis().setLabel("Ilość znaków");

    }
    
    @FXML
    public void handleChartSelection(){
        showChart();
    }
    
    private XYChart.Series<String, Integer> createChartDataSeries(ChartData e, int numberOfSeries) {
        XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
            for (int i = 0; i < e.getListOfLines().size() - 1; i++) {
                XYChart.Data<String, Integer> chartData = new XYChart.Data<String, Integer>(String.valueOf(i+1), e.getListOfLines().get(i));
                series.getData().add(chartData);
                series.setName("Plik " + numberOfSeries);
            }
        return series;
    }
    
    
    

}
