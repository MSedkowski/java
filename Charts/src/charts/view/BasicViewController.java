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
    private final String labelXAxis = "Numer linii";
    private final String labelYAxis = "Liczba znaków";

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
        } else if (chartType.getSelectedToggle().equals(lineChartButton)) {
            scatterChart.setVisible(false);
            barChart.setVisible(false);
            lineChart.setVisible(true);
        } else if (chartType.getSelectedToggle().equals(barChartButton)) {
            lineChart.setVisible(false);
            scatterChart.setVisible(false);
            barChart.setVisible(true);
        }
    }

    private void createLineChart() {
        int numberOfSeries = 1;
        for (ChartData chartData : listOfChartData.getListOfChartData()) {
            XYChart.Series<String, Integer> series = createChartDataSeries(chartData, numberOfSeries);
            lineChart.getData().add(series);
            numberOfSeries++;
        }
        lineChart.getXAxis().setLabel(labelXAxis);
        lineChart.getYAxis().setLabel(labelYAxis);

    }

    private void createBarChart() {
        int numberOfSeries = 1;
        for (ChartData chartData : listOfChartData.getListOfChartData()) {
            XYChart.Series<String, Integer> series = createChartDataSeries(chartData, numberOfSeries);
            barChart.getData().add(series);
            numberOfSeries++;
        }
        barChart.getXAxis().setLabel(labelXAxis);
        barChart.getYAxis().setLabel(labelYAxis);

    }

    private void createScatterChart() {
        int numberOfSeries = 1;
        for (ChartData chartData : listOfChartData.getListOfChartData()) {
            XYChart.Series<String, Integer> series = createChartDataSeries(chartData, numberOfSeries);
            scatterChart.getData().add(series);
            numberOfSeries++;
        }
        scatterChart.getXAxis().setLabel(labelXAxis);
        scatterChart.getYAxis().setLabel(labelYAxis);

    }

    @FXML
    public void handleChartSelection() {
        showChart();
    }

    private XYChart.Series<String, Integer> createChartDataSeries(ChartData chartData, int numberOfSeries) {
        XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
        for (int i = 0; i < chartData.getListOfLines().size() - 1; i++) {
            XYChart.Data<String, Integer> data = new XYChart.Data<String, Integer>(String.valueOf(i + 1), chartData.getListOfLines().get(i));
            series.getData().add(data);
            series.setName("Plik " + numberOfSeries);
        }
        return series;
    }

}
