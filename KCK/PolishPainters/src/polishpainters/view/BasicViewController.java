package polishpainters.view;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import polishpainters.PolishPainters;
import polishpainters.model.ListOfPainters;

public class BasicViewController{

    @FXML
    private Label painterNameLabel;
    @FXML
    private Label painterBirthLabel;
    @FXML
    private Label paintingName;
    @FXML
    private Label paintingData;
    @FXML
    private Label paintingLocation;
    @FXML
    private ImageView paintingView;
    @FXML
    private ComboBox<String> paintersListInCombobox;

    private Integer numberOfPainting = 0;
    private Integer currentPainterNumber = 0;
    private ListOfPainters listOfPainters;
    private ObservableList<String> paintersNameList = FXCollections.observableArrayList();;
    
    @FXML
    private void initialize() {
    }

    public void setMainApp(PolishPainters main, ListOfPainters listOfPainters) {
        this.listOfPainters = listOfPainters;
        createAndShowPaintersListInComboBox(listOfPainters);
        showPainterDetails(listOfPainters, currentPainterNumber);
        showPaintingDetails(listOfPainters, currentPainterNumber, numberOfPainting);
    }
    
    public void createAndShowPaintersListInComboBox(ListOfPainters listOfPainters) {
        for (int i = 0; i < listOfPainters.getListOfPainters().size() - 1; i++ ) {
        paintersNameList.add(listOfPainters.getListOfPainters().get(i).getPainterName());
        }
        paintersListInCombobox.getItems().setAll(paintersNameList);
        paintersListInCombobox.setPromptText("Malarze polscy");
        
    }
    
    @FXML 
    public void handleSelectionItem() {
        paintersListInCombobox.setOnAction((ev) -> {
            currentPainterNumber =  paintersListInCombobox.getSelectionModel().getSelectedIndex();
            numberOfPainting = 0;
            showPainterDetails(listOfPainters, currentPainterNumber);
            showPaintingDetails(listOfPainters, numberOfPainting, currentPainterNumber);
        });
        
    }
    public void showPainterDetails(ListOfPainters listOfPainters, Integer currentPainterNumber) {
        painterNameLabel.setText(listOfPainters.getListOfPainters().get(currentPainterNumber).getPainterName());
        painterBirthLabel.setText(listOfPainters.getListOfPainters().get(currentPainterNumber).getPainterBirthDate());
    }

    public void showPaintingDetails(ListOfPainters listOfPainters, Integer numberOfPainting, Integer currentPainterNumber) {
        paintingName.setText(listOfPainters.getListOfPainters().get(currentPainterNumber).getListOfPaintings().get(numberOfPainting).getPaintingName());
        paintingData.setText(listOfPainters.getListOfPainters().get(currentPainterNumber).getListOfPaintings().get(numberOfPainting).getPaintingData());
        paintingLocation.setText(listOfPainters.getListOfPainters().get(currentPainterNumber).getListOfPaintings().get(numberOfPainting).getPaintingLocation());
        paintingView.setImage(new Image("file:./paintings/" + listOfPainters.getListOfPainters().get(currentPainterNumber).getListOfPaintings().get(numberOfPainting).getFileSource()));
        paintingFadeTransition(0, 1);
    }
    
    public void paintingFadeTransition(Integer fromValue, Integer toValue) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(750) );
            fadeTransition.setNode(paintingView);
            fadeTransition.setFromValue(fromValue);
            fadeTransition.setToValue(toValue);
            fadeTransition.setCycleCount(50);
            fadeTransition.setAutoReverse(false);
            fadeTransition.setCycleCount(1);
            fadeTransition.play();
    }

    @FXML
    private void handleNextPainting() {
        if (numberOfPainting >= 0 && numberOfPainting < listOfPainters.getListOfPainters().get(currentPainterNumber).getListOfPaintings().size() - 1) {
            numberOfPainting++;
            showPaintingDetails(listOfPainters, numberOfPainting, currentPainterNumber);
        }
    }

    @FXML
    private void handlePreviousPainting() {
        if (numberOfPainting > 0 && numberOfPainting <= listOfPainters.getListOfPainters().get(currentPainterNumber).getListOfPaintings().size() - 1) {
            numberOfPainting--;
            showPaintingDetails(listOfPainters, numberOfPainting, currentPainterNumber);
        }
    }
}
