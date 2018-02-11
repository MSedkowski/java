package ludo.client.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import ludo.common.Board;
import ludo.client.Client;
import ludo.common.Field;
import ludo.common.Player;
import ludo.common.PlayerList;
import ludo.common.Request;
import ludo.common.Token;

/**
 * FXML Controller class
 *
 * @author Mateusz
 */
public class GeneralViewController {
 
    @FXML
    private Button diceRollButton;
    @FXML 
    private Label rollDiceLabel;
    
    @FXML
    private Label bluePlayer;
    @FXML
    private Label greenPlayer;
    @FXML
    private Label yellowPlayer;
    @FXML
    private Label redPlayer;
    
    @FXML 
    private ImageView bluePlayerArrow;
    @FXML 
    private ImageView greenPlayerArrow;
    @FXML 
    private ImageView yellowPlayerArrow;
    @FXML 
    private ImageView redPlayerArrow;
    @FXML
    private Button skipTurnButton;
    @FXML 
    private Button button0;
    @FXML 
    private Button button1;
    @FXML 
    private Button button2;
    @FXML 
    private Button button3;
    @FXML 
    private Button button4;
    @FXML 
    private Button button5;
    @FXML 
    private Button button6;
    @FXML 
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML 
    private Button button10;
    @FXML 
    private Button button11;
    @FXML 
    private Button button12;
    @FXML 
    private Button button13;
    @FXML 
    private Button button14;
    @FXML 
    private Button button15;
    @FXML 
    private Button button16;
    @FXML 
    private Button button17;
    @FXML
    private Button button18;
    @FXML
    private Button button19;
    @FXML 
    private Button button20;
    @FXML 
    private Button button21;
    @FXML 
    private Button button22;
    @FXML 
    private Button button23;
    @FXML 
    private Button button24;
    @FXML 
    private Button button25;
    @FXML 
    private Button button26;
    @FXML 
    private Button button27;
    @FXML
    private Button button28;
    @FXML
    private Button button29;
    @FXML 
    private Button button30;
    @FXML 
    private Button button31;
    @FXML 
    private Button button32;
    @FXML 
    private Button button33;
    @FXML 
    private Button button34;
    @FXML 
    private Button button35;
    @FXML 
    private Button button36;
    @FXML 
    private Button button37;
    @FXML
    private Button button38;
    @FXML
    private Button button39;
    @FXML 
    private Button button40;
    @FXML 
    private Button button41;
    @FXML 
    private Button button42;
    @FXML 
    private Button button43;
    @FXML 
    private Button button44;
    @FXML 
    private Button button45;
    @FXML 
    private Button button46;
    @FXML 
    private Button button47;
    @FXML
    private Button button48;
    @FXML
    private Button button49;
    @FXML 
    private Button button50;
    @FXML 
    private Button button51;
    @FXML 
    private Button button52;
    @FXML 
    private Button button53;
    @FXML 
    private Button button54;
    @FXML 
    private Button button55;
    @FXML 
    private Button button56;
    @FXML 
    private Button button57;
    @FXML
    private Button button58;
    @FXML
    private Button button59;
    @FXML 
    private Button button60;
    @FXML 
    private Button button61;
    @FXML 
    private Button button62;
    @FXML 
    private Button button63;
    @FXML 
    private Button button64;
    @FXML 
    private Button button65;
    @FXML 
    private Button button66;
    @FXML 
    private Button button67;
    @FXML
    private Button button68;
    @FXML
    private Button button69;
    @FXML 
    private Button button70;
    @FXML 
    private Button button71;

    private Board board;
    private PlayerList listOfPlayers;
    private Integer diceRoll;
    private HashMap<Button, Field> buttonMap;
    private List<Button> listOfButtons;
    private final int blueTokens[] = {0,57,58,59};
    private final int greenTokens[] = {10,61,62,63};
    private final int yellowTokens[] = {20,65,66,67};
    private final int redTokens[] = {30,69,70,71};
    private final List<Button> blueButtons = new ArrayList<>();
    private final List<Button> greenButtons = new ArrayList<>();
    private final List<Button> yellowButtons = new ArrayList<>();
    private final List<Button> redButtons = new ArrayList<>();
    private Stage gameStage;
    private Client client;
    private boolean activeTurn;
    
    public void initialize() {
    }    
        
    
    public void setEnterStage(Stage gameStage, Client client) {
        this.gameStage = gameStage;
        this.client = client;
    }
    public void createListOfButtons()
    {
        this.listOfButtons = new ArrayList<>();
        //Pola 0 - 10
        this.listOfButtons.add(button0);
        this.listOfButtons.add(button1);
        this.listOfButtons.add(button2);
        this.listOfButtons.add(button3);
        this.listOfButtons.add(button4);
        this.listOfButtons.add(button5);
        this.listOfButtons.add(button6);
        this.listOfButtons.add(button7);
        this.listOfButtons.add(button8);
        this.listOfButtons.add(button9);
        //Pola 11 - 20
        this.listOfButtons.add(button10);
        this.listOfButtons.add(button11);
        this.listOfButtons.add(button12);
        this.listOfButtons.add(button13);
        this.listOfButtons.add(button14);
        this.listOfButtons.add(button15);
        this.listOfButtons.add(button16);
        this.listOfButtons.add(button17);
        this.listOfButtons.add(button18);
        this.listOfButtons.add(button19);
        //Pola 21 - 30
        this.listOfButtons.add(button20);
        this.listOfButtons.add(button21);
        this.listOfButtons.add(button22);
        this.listOfButtons.add(button23);
        this.listOfButtons.add(button24);
        this.listOfButtons.add(button25);
        this.listOfButtons.add(button26);
        this.listOfButtons.add(button27);
        this.listOfButtons.add(button28);
        this.listOfButtons.add(button29);
        //Pola 31 - 40
        this.listOfButtons.add(button30);
        this.listOfButtons.add(button31);
        this.listOfButtons.add(button32);
        this.listOfButtons.add(button33);
        this.listOfButtons.add(button34);
        this.listOfButtons.add(button35);
        this.listOfButtons.add(button36);
        this.listOfButtons.add(button37);
        this.listOfButtons.add(button38);
        this.listOfButtons.add(button39);
        //Pola 41 - 50
        this.listOfButtons.add(button40);
        this.listOfButtons.add(button41);
        this.listOfButtons.add(button42);
        this.listOfButtons.add(button43);
        this.listOfButtons.add(button44);
        this.listOfButtons.add(button45);
        this.listOfButtons.add(button46);
        this.listOfButtons.add(button47);
        this.listOfButtons.add(button48);
        this.listOfButtons.add(button49);
        //Pola 51 - 60
        this.listOfButtons.add(button50);
        this.listOfButtons.add(button51);
        this.listOfButtons.add(button52);
        this.listOfButtons.add(button53);
        this.listOfButtons.add(button54);
        this.listOfButtons.add(button55);
        this.listOfButtons.add(button56);
        this.listOfButtons.add(button57);
        this.listOfButtons.add(button58);
        this.listOfButtons.add(button59);
        //Pola 61 - 70
        this.listOfButtons.add(button60);
        this.listOfButtons.add(button61);
        this.listOfButtons.add(button62);
        this.listOfButtons.add(button63);
        this.listOfButtons.add(button64);
        this.listOfButtons.add(button65);
        this.listOfButtons.add(button66);
        this.listOfButtons.add(button67);
        this.listOfButtons.add(button68);
        this.listOfButtons.add(button69);
        //Pola 71 - 72
        this.listOfButtons.add(button70);
        this.listOfButtons.add(button71);
    }
    
    public void initializeListOfPlayers(PlayerList listOfPlayers)
    {
        this.listOfPlayers = listOfPlayers;
        this.bluePlayer.setText(listOfPlayers.getPlayer(0).getName());
        if(listOfPlayers.getPlayerList().size() > 1 && listOfPlayers.getPlayer(1) != null)
            this.greenPlayer.setText(listOfPlayers.getPlayer(1).getName());
        if(listOfPlayers.getPlayerList().size() > 2 && listOfPlayers.getPlayer(2) != null)
            this.yellowPlayer.setText(listOfPlayers.getPlayer(2).getName());
        if(listOfPlayers.getPlayerList().size() > 3 && listOfPlayers.getPlayer(3) != null)
            this.redPlayer.setText(listOfPlayers.getPlayer(3).getName());
        listOfPlayers.getPlayer(0).setIsMyTurn(true);
        this.bluePlayerArrow.setVisible(true);
    }
    
    public void initializeListOfFields()
    {
        int i = 0;
        
        for (i = 0; i < 72; i++)
        {
            listOfButtons.get(i).opacityProperty().set(0);
            listOfButtons.get(i).setDisable(true);
        }
        this.diceRollButton.setDisable(true);
        this.skipTurnButton.setDisable(true);
        if(this.listOfPlayers.getPlayerList().size() == 4) {
        this.board = new Board(listOfPlayers);
        this.buttonMap = new HashMap<>();
        i = 0;
        for(Field field : board.getListOfFields())
        {
            this.buttonMap.put(listOfButtons.get(i), field);
            i++;
        }
        if(this.client.getMyId() == 3) {
            Request request = new Request(101, this.board);
            client.sendRequest(request);
        }
        }
    }
    
    public void setTokens()
    {
        this.blueButtons.add(button56);
        this.blueButtons.add(button57);
        this.blueButtons.add(button58);
        this.blueButtons.add(button59);
        this.greenButtons.add(button60);
        this.greenButtons.add(button61);
        this.greenButtons.add(button62);
        this.greenButtons.add(button63);
        this.yellowButtons.add(button64);
        this.yellowButtons.add(button65);
        this.yellowButtons.add(button66);
        this.yellowButtons.add(button67);
        this.redButtons.add(button68);
        this.redButtons.add(button69);
        this.redButtons.add(button70);
        this.redButtons.add(button71);
        
        for(int i = 0; i < 4; i++)
        {
            listOfButtons.get(blueTokens[i]).setStyle("-fx-base: #0090FF; "
                    + "-fx-background-radius: 50%;");
            listOfButtons.get(blueTokens[i]).setDisable(false);
            listOfButtons.get(blueTokens[i]).setOpacity(1);
        }
        for(int i = 0; i < 4; i++)
        {
            listOfButtons.get(greenTokens[i]).setStyle("-fx-base: #00B200; "
                    + "-fx-background-radius: 50%;");
            listOfButtons.get(greenTokens[i]).setDisable(false);
            listOfButtons.get(greenTokens[i]).setOpacity(1);
        }
        for(int i = 0; i < 4; i++)
        {
            listOfButtons.get(yellowTokens[i]).setStyle("-fx-base: #F6C900; "
                    + "-fx-background-radius: 50%;");
            listOfButtons.get(yellowTokens[i]).setDisable(false);
            listOfButtons.get(yellowTokens[i]).setOpacity(1);
        }
        for(int i = 0; i < 4; i++)
        {
            listOfButtons.get(redTokens[i]).setStyle("-fx-base: #DE0600; "
                    + "-fx-background-radius: 50%;");
            listOfButtons.get(redTokens[i]).setDisable(false);
            listOfButtons.get(redTokens[i]).setOpacity(1);
        }
        Request request = new Request(102, 0);
        client.sendRequest(request);
    }
    
    public void setActivePlayer(String color) {
        setActive(color);
        if(client.getColor().toString().equalsIgnoreCase(color)) {
            this.activeTurn = true;
            this.diceRollButton.setDisable(false);
            this.skipTurnButton.setDisable(false);
        }
        else {
            this.activeTurn = false;
            this.diceRollButton.setDisable(true);
            this.skipTurnButton.setDisable(true);
        }
    }
    
    public void handleRollDiceButton(ActionEvent event) 
    {
        this.diceRoll = board.rollDice();
        this.rollDiceLabel.setText("" + diceRoll);
        this.diceRollButton.setDisable(true);
    }
    
    public void handleSkipTurn(ActionEvent event)
    {
        String color = "";
        for(Player player : listOfPlayers.getPlayerList())
        {
            color = player.getColor();
            if(player.isIsMyTurn())
            {
                player.setIsMyTurn(false);
                break;
            }
        }
        this.diceRoll = null;
        setNextActive(color);
        this.diceRollButton.setDisable(false);
        Request request;
        if(this.client.getMyId() == 3) {
            request = new Request(103, 0);
        }
        else {
            request = new Request(103, this.client.getMyId() + 1);
        }
        client.sendRequest(request);
    }
    
    public void handleMakeMove(ActionEvent event)
    {
        if(diceRoll != null) {
        Button source = (Button)event.getSource();
        Field sourceField = buttonMap.get(source);
        int index = board.getListOfFields().indexOf(sourceField) + diceRoll;
        int tokenID = sourceField.getTokenID();
        Player sourcePlayer = null;
        Token sourceToken = null;
        for (Player player : listOfPlayers.getPlayerList())
        {
            sourcePlayer = player;
            sourceToken = player.getTokenById(tokenID);
            if(sourceToken != null) break;
        }
        if(sourcePlayer.isIsMyTurn()){
            if(sourceToken.isIsInGarage() && (diceRoll == 1 || diceRoll == 6)){
                if(isStartingFieldClear(sourcePlayer))
                {
                    source.setDisable(true);
                    source.setOpacity(0);
                    sourceField.setIsOccupied(false);
                    sourceField.setTokenID(null);
                    buttonMap.get(listOfButtons.get(sourceField.getNumber())).setIsOccupied(false);
                    buttonMap.get(listOfButtons.get(sourceField.getNumber())).setTokenID(null);
                    takeFromGarage(sourceToken, sourcePlayer);
                    this.diceRoll = null;
                    this.rollDiceLabel.setText(" ");
                    setNextActive(sourcePlayer.getColor());
                    this.diceRollButton.setDisable(false);
                    Request request;
                    
                    request = new Request(105, this.listOfPlayers);
                    client.sendRequest(request);
                    request = new Request(104, this.board);
                    client.sendRequest(request);
                    if(this.client.getMyId() == 3) {
                        request = new Request(103, 0);
                    }
                    else {
                        request = new Request(103, this.client.getMyId() + 1);
                    }
                    client.sendRequest(request);
                }
            }
            else if(sourceToken.isIsOnTheField())
            {
                if(sourceToken.getCounter() + diceRoll < 40)
                {
                    if(isMovePossible(sourceField, sourcePlayer)) {
                        removeOtherTokenFromEndField(sourceField);
                        makeMove(sourceField, sourceToken, sourcePlayer);
                        this.diceRoll = null;
                        this.rollDiceLabel.setText(" ");
                        setNextActive(sourcePlayer.getColor());
                        this.diceRollButton.setDisable(false);
                        Request request;
                
                request = new Request(105, this.listOfPlayers);
                client.sendRequest(request);
                request = new Request(104, this.board);
                client.sendRequest(request);
                if(this.client.getMyId() == 3) {
                    request = new Request(103, 0);
                }
                else {
                    request = new Request(103, this.client.getMyId() + 1);
                }
                client.sendRequest(request);
                    }
                }
                else 
                {
                    takeToWinningField(sourceField, sourceToken, sourcePlayer);
                    this.diceRoll = null;
                    this.rollDiceLabel.setText(" ");
                    setNextActive(sourcePlayer.getColor());
                    this.diceRollButton.setDisable(false);
                    Request request;
                
                request = new Request(105, this.listOfPlayers);
                client.sendRequest(request);
                request = new Request(104, this.board);
                client.sendRequest(request);
                if(this.client.getMyId() == 3) {
                    request = new Request(103, 0);
                }
                else {
                    request = new Request(103, this.client.getMyId() + 1);
                }
                client.sendRequest(request);
                }
                
            }
        }
        }
        
    }
    
    private void removeOtherTokenFromEndField(Field sourceField) {
        int index = 0;
        if(sourceField.getNumber() + diceRoll > 39)
            index = sourceField.getNumber() + diceRoll - 40;
        else 
            index = sourceField.getNumber() + diceRoll;
        Field endField = board.getListOfFields().get(index);
        buttonMap.get(listOfButtons.get(sourceField.getNumber())).setIsOccupied(false);
        buttonMap.get(listOfButtons.get(sourceField.getNumber())).setTokenID(null);
        if(endField.isIsOccupied()) {
            String endFieldTokenColor = null;
            Integer endFieldTokenID = endField.getTokenID();
            Token endToken = null;
            for(Player player : listOfPlayers.getPlayerList()) {
                endFieldTokenColor = player.getColor();
                endToken = player.getTokenById(endFieldTokenID);
                if(endToken != null)
                    break;
            }
            switch(endFieldTokenColor) {
                case "blue": {
                    for(int i = 59; i > 55; i--) {
                        Field garage = board.getListOfFields().get(i);
                        if(!garage.isIsOccupied()) {
                            endToken.setFieldNumber(garage.getNumber());
                            endToken.setIsInGarage(true);
                            endToken.setIsOnTheField(false);
                            garage.setTokenID(endToken.getId());
                            garage.setIsOccupied(true);
                            buttonMap.get(listOfButtons.get(garage.getNumber())).setIsOccupied(true);
                            buttonMap.get(listOfButtons.get(garage.getNumber())).setTokenID(endToken.getId());
                            listOfButtons.get(garage.getNumber()).setDisable(false);
                            listOfButtons.get(garage.getNumber()).setOpacity(1);
                            listOfButtons.get(garage.getNumber()).setStyle("-fx-base: #0090FF; "
                            + "-fx-background-radius: 50%;");
                            break;
                        }
                    }
                    break;
                }
                case "green": {
                    for(int i = 63; i > 59; i--) {
                        Field garage = board.getListOfFields().get(i);
                        if(!garage.isIsOccupied()) {
                            endToken.setFieldNumber(garage.getNumber());
                            endToken.setIsInGarage(true);
                            endToken.setIsOnTheField(false);
                            garage.setTokenID(endToken.getId());
                            garage.setIsOccupied(true);
                            buttonMap.get(listOfButtons.get(garage.getNumber())).setIsOccupied(true);
                            buttonMap.get(listOfButtons.get(garage.getNumber())).setTokenID(endToken.getId());
                            listOfButtons.get(garage.getNumber()).setDisable(false);
                            listOfButtons.get(garage.getNumber()).setOpacity(1);
                            listOfButtons.get(garage.getNumber()).setStyle("-fx-base: #00B200; "
                            + "-fx-background-radius: 50%;");
                            break;
                        }
                    }
                    break;
                }
                case "yellow": {
                    for(int i = 67; i > 63; i--) {
                        Field garage = board.getListOfFields().get(i);
                        if(!garage.isIsOccupied()) {
                            endToken.setFieldNumber(garage.getNumber());
                            endToken.setIsInGarage(true);
                            endToken.setIsOnTheField(false);
                            garage.setTokenID(endToken.getId());
                            garage.setIsOccupied(true);
                            buttonMap.get(listOfButtons.get(garage.getNumber())).setIsOccupied(true);
                            buttonMap.get(listOfButtons.get(garage.getNumber())).setTokenID(endToken.getId());
                            listOfButtons.get(garage.getNumber()).setDisable(false);
                            listOfButtons.get(garage.getNumber()).setOpacity(1);
                            listOfButtons.get(garage.getNumber()).setStyle("-fx-base: #F6C900; "
                            + "-fx-background-radius: 50%;");
                            break;
                        }
                    }
                    break;
                }
                case "red": {
                    for(int i = 71; i > 67; i--) {
                        Field garage = board.getListOfFields().get(i);
                        if(!garage.isIsOccupied()) {
                            endToken.setFieldNumber(garage.getNumber());
                            endToken.setIsInGarage(true);
                            endToken.setIsOnTheField(false);
                            garage.setTokenID(endToken.getId());
                            garage.setIsOccupied(true);
                            buttonMap.get(listOfButtons.get(garage.getNumber())).setIsOccupied(true);
                            buttonMap.get(listOfButtons.get(garage.getNumber())).setTokenID(endToken.getId());
                            listOfButtons.get(garage.getNumber()).setDisable(false);
                            listOfButtons.get(garage.getNumber()).setOpacity(1);
                            listOfButtons.get(garage.getNumber()).setStyle("-fx-base: #DE0600; "
                            + "-fx-background-radius: 50%;");
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }
    
    private boolean isMovePossible(Field sourceField, Player sourcePlayer) {
        String sourceColor = sourcePlayer.getColor();
        int index = 0;
        if(sourceField.getNumber() + diceRoll > 39)
            index = sourceField.getNumber() + diceRoll - 40;
        else 
            index = sourceField.getNumber() + diceRoll;
        String endFieldTokenColor = null;
        Integer endFieldTokenID = null;
        if(board.getListOfFields().get(index).isIsOccupied()) {
            endFieldTokenID = board.getListOfFields().get(index).getTokenID();
            for(Player player : listOfPlayers.getPlayerList()) {
                endFieldTokenColor = player.getColor();
                if(player.getTokenById(endFieldTokenID) != null) {
                    break;
                }
            }
        }
        if(endFieldTokenColor != null) {
            if(endFieldTokenColor.equalsIgnoreCase(sourceColor)) {
                return false;
            }
            else {
                return true;
            }
        }
        return true;
        
    }
    
    private void takeToWinningField(Field sourceField, Token sourceToken, Player sourcePlayer)
    {
        String color = sourcePlayer.getColor();
        int index = sourceField.getNumber();
        buttonMap.get(listOfButtons.get(index)).setIsOccupied(false);
        buttonMap.get(listOfButtons.get(index)).setTokenID(null);
        board.getListOfFields().get(index).setIsOccupied(false);
        board.getListOfFields().get(index).setTokenID(null);
        listOfButtons.get(index).setDisable(true);
        listOfButtons.get(index).setOpacity(0);
        switch(color) {
            case "blue": {
                for(int i = 43; i > 39; i--) {
                    Field winningField = board.getListOfFields().get(i);
                    if(!winningField.isIsOccupied()) {
                        sourceToken.setFieldNumber(winningField.getNumber());
                        winningField.setTokenID(sourceToken.getId());
                        winningField.setIsOccupied(true);
                        listOfButtons.get(winningField.getNumber()).setOpacity(1);
                        listOfButtons.get(winningField.getNumber()).setStyle("-fx-base: #0090FF; "
                    + "-fx-background-radius: 50%;");
                        if(i == 40)
                            showWinningScreen(sourcePlayer);
                        else 
                            break;
                    }
                }
                break;
            }
            case "green": {
                for(int i = 47; i > 43; i--) {
                    Field winningField = board.getListOfFields().get(i);
                    if(!winningField.isIsOccupied()) {
                        sourceToken.setFieldNumber(winningField.getNumber());
                        winningField.setTokenID(sourceToken.getId());
                        winningField.setIsOccupied(true);
                        listOfButtons.get(winningField.getNumber()).setOpacity(1);
                        listOfButtons.get(winningField.getNumber()).setStyle("-fx-base: #00B200; "
                    + "-fx-background-radius: 50%;");
                        if(i == 44)
                            showWinningScreen(sourcePlayer);
                        else 
                            break;
                    }
                }
                break;
            }
            case "yellow": {
                for(int i = 51; i > 47; i--) {
                    Field winningField = board.getListOfFields().get(i);
                    if(!winningField.isIsOccupied()) {
                        sourceToken.setFieldNumber(winningField.getNumber());
                        winningField.setTokenID(sourceToken.getId());
                        winningField.setIsOccupied(true);
                        listOfButtons.get(winningField.getNumber()).setOpacity(1);
                        listOfButtons.get(winningField.getNumber()).setStyle("-fx-base: #F6C900; "
                    + "-fx-background-radius: 50%;");
                        if(i == 48)
                            showWinningScreen(sourcePlayer);
                        else 
                            break;
                    }
                }
                break;
            }
            case "red": {
                for(int i = 55; i > 51; i--) {
                    Field winningField = board.getListOfFields().get(i);
                    if(!winningField.isIsOccupied()) {
                        sourceToken.setFieldNumber(winningField.getNumber());
                        winningField.setTokenID(sourceToken.getId());
                        winningField.setIsOccupied(true);
                        listOfButtons.get(winningField.getNumber()).setOpacity(1);
                        listOfButtons.get(winningField.getNumber()).setStyle("-fx-base: #DE0600; "
                    + "-fx-background-radius: 50%;");
                        if(i == 52)
                            showWinningScreen(sourcePlayer);
                        else 
                            break;
                    }
                }
                break;
            }
        }
    }
    
    private void showWinningScreen(Player sourcePlayer)
    {
        Request request = new Request(106, client.getMyId());
        client.sendRequest(request);
    }
    
    private void makeMove(Field sourceField, Token sourceToken, Player sourcePlayer)
    {
        int index = 0;
        if(sourceField.getNumber() + diceRoll > 39)
            index = sourceField.getNumber() + diceRoll - 40;
        else 
            index = sourceField.getNumber() + diceRoll;
        String color = sourcePlayer.getColor();
        sourceField.setTokenID(null);
        sourceField.setIsOccupied(false);
        board.getListOfFields().get(sourceField.getNumber()).setIsOccupied(false);
        board.getListOfFields().get(sourceField.getNumber()).setTokenID(null);
        sourceToken.setCounter(sourceToken.getCounter() + diceRoll);
        sourceToken.setFieldNumber(index);
        board.getListOfFields().get(index).setTokenID(sourceToken.getId());
        board.getListOfFields().get(index).setIsOccupied(true);
        listOfButtons.get(sourceField.getNumber()).setOpacity(0);
        listOfButtons.get(sourceField.getNumber()).setDisable(true);
        listOfButtons.get(index).setOpacity(1);
        listOfButtons.get(index).setDisable(false);
        switch(color) {
            case "blue": {
                listOfButtons.get(index).setStyle("-fx-base: #0090FF; "
                                                        + "-fx-background-radius: 50%;");
                break;
            }
            case "green": {
                listOfButtons.get(index).setStyle("-fx-base: #00B200; "
                                                        + "-fx-background-radius: 50%;");
                break;
            }
            case "yellow": {
                listOfButtons.get(index).setStyle("-fx-base: #F6C900; "
                                                        + "-fx-background-radius: 50%;");
                break;
            }
            case "red": {
                listOfButtons.get(index).setStyle("-fx-base: #DE0600; "
                                                        + "-fx-background-radius: 50%;");
                break;
            }
        }
        
    }
    
    private void takeFromGarage(Token sourceToken, Player sourcePlayer)
    {
        String color = sourcePlayer.getColor();
        removeOtherPlayerTokenFromMyStartField(sourcePlayer, color);
        setOnStartField(sourceToken, color);
    }
    
    private void setOnStartField(Token sourceToken, String color)
    {
        board.getListOfFields().get(sourceToken.getFieldNumber()).setIsOccupied(false);
        board.getListOfFields().get(sourceToken.getFieldNumber()).setTokenID(null);
        sourceToken.setOnStartField(color);
        board.setTokenOnStartField(sourceToken.getId());
        listOfButtons.get(sourceToken.getFieldNumber()).setDisable(true);
        listOfButtons.get(sourceToken.getFieldNumber()).setOpacity(0);
        switch(color) {
            case "blue": {
                listOfButtons.get(0).setStyle("-fx-base: #0090FF; "
                    + "-fx-background-radius: 50%;");
                listOfButtons.get(0).setDisable(false);
                listOfButtons.get(0).setOpacity(1);
                break;
            }
            case "green": {
                listOfButtons.get(10).setStyle("-fx-base: #00B200; "
                    + "-fx-background-radius: 50%;");
                listOfButtons.get(10).setDisable(false);
                listOfButtons.get(10).setOpacity(1);
                break;
            }
            case "yellow": {
                listOfButtons.get(20).setStyle("-fx-base: #F6C900; "
                    + "-fx-background-radius: 50%;");
                listOfButtons.get(20).setDisable(false);
                listOfButtons.get(20).setOpacity(1);
                break;
            }
            case "red": {
                listOfButtons.get(30).setStyle("-fx-base: #DE0600; "
                    + "-fx-background-radius: 50%;");
                listOfButtons.get(30).setDisable(false);
                listOfButtons.get(30).setOpacity(1);
                break;
            }
        }
    }
    
    private void removeOtherPlayerTokenFromMyStartField(Player sourcePlayer, String color)
    {
        switch(color) {
            case "blue": {
                if(buttonMap.get(button0).isIsOccupied())
                {
                    Integer tokenID = buttonMap.get(button0).getTokenID();
                    Token sourceToken = null; 
                    String sourceColor = null;
                    for (Player player : listOfPlayers.getPlayerList())
                    {
                        sourceColor = player.getColor();
                        sourceToken = player.getTokenById(tokenID);
                        if (sourceToken != null) break;
                    }
                    buttonMap.get(button0).setIsOccupied(false);
                    buttonMap.get(button0).setTokenID(null);
                    board.getListOfFields().get(0).setIsOccupied(false);
                    board.getListOfFields().get(0).setTokenID(null);
                    if(sourceColor.equalsIgnoreCase("green"))
                    {
                        for(Button button : greenButtons)
                        {
                            if(!buttonMap.get(button).isIsOccupied())
                            {
                                int index = listOfButtons.indexOf(button);
                                buttonMap.get(button).setIsOccupied(true);
                                buttonMap.get(button).setTokenID(tokenID);
                                board.getListOfFields().get(index).setIsOccupied(true);
                                board.getListOfFields().get(index).setTokenID(tokenID);
                                sourceToken.setCounter(0);
                                sourceToken.setFieldNumber(buttonMap.get(button).getNumber());
                                sourceToken.setIsInGarage(true);
                                sourceToken.setIsOnTheField(false);
                                listOfButtons.get(index).setStyle("-fx-base: #00B200; "
                                                        + "-fx-background-radius: 50%;");
                                listOfButtons.get(index).setDisable(false);
                                listOfButtons.get(index).setOpacity(1);
                                break; 
                            }
                        }
                    }
                    if(sourceColor.equalsIgnoreCase("yellow"))
                    {
                        for(Button button : yellowButtons)
                        {
                            if(!buttonMap.get(button).isIsOccupied())
                            {
                                int index = listOfButtons.indexOf(button);
                                buttonMap.get(button).setIsOccupied(true);
                                buttonMap.get(button).setTokenID(tokenID);
                                board.getListOfFields().get(index).setIsOccupied(true);
                                board.getListOfFields().get(index).setTokenID(tokenID);
                                sourceToken.setCounter(0);
                                sourceToken.setFieldNumber(buttonMap.get(button).getNumber());
                                sourceToken.setIsInGarage(true);
                                sourceToken.setIsOnTheField(false);
                                listOfButtons.get(index).setStyle("-fx-base: #F6C900; "
                                                        + "-fx-background-radius: 50%;");
                                listOfButtons.get(index).setDisable(false);
                                listOfButtons.get(index).setOpacity(1);
                                break; 
                            }
                        }
                    }
                    if(sourceColor.equalsIgnoreCase("red"))
                    {
                        for(Button button : redButtons)
                        {
                            if(!buttonMap.get(button).isIsOccupied())
                            {
                                int index = listOfButtons.indexOf(button);
                                buttonMap.get(button).setIsOccupied(true);
                                buttonMap.get(button).setTokenID(tokenID);
                                board.getListOfFields().get(index).setIsOccupied(true);
                                board.getListOfFields().get(index).setTokenID(tokenID);
                                sourceToken.setCounter(0);
                                sourceToken.setFieldNumber(buttonMap.get(button).getNumber());
                                sourceToken.setIsInGarage(true);
                                sourceToken.setIsOnTheField(false);
                                listOfButtons.get(index).setStyle("-fx-base: #DE0600; "
                                                        + "-fx-background-radius: 50%;");
                                listOfButtons.get(index).setDisable(false);
                                listOfButtons.get(index).setOpacity(1);
                                break; 
                            }
                        }
                    }
                }
                break;
            }
            case "green": {
                if(buttonMap.get(button10).isIsOccupied())
                {
                    Integer tokenID = buttonMap.get(button10).getTokenID();
                    Token sourceToken = null; 
                    String sourceColor = null;
                    for (Player player : listOfPlayers.getPlayerList())
                    {
                        sourceColor = player.getColor();
                        sourceToken = player.getTokenById(tokenID);
                        if (sourceToken != null) break;
                    }
                    buttonMap.get(button10).setIsOccupied(false);
                    buttonMap.get(button10).setTokenID(null);
                    board.getListOfFields().get(10).setIsOccupied(false);
                    board.getListOfFields().get(10).setTokenID(null);
                    if(sourceColor.equalsIgnoreCase("blue"))
                    {
                        for(Button button : blueButtons)
                        {
                            if(!buttonMap.get(button).isIsOccupied())
                            {
                                int index = listOfButtons.indexOf(button);
                                buttonMap.get(button).setIsOccupied(true);
                                buttonMap.get(button).setTokenID(tokenID);
                                board.getListOfFields().get(index).setIsOccupied(true);
                                board.getListOfFields().get(index).setTokenID(tokenID);
                                sourceToken.setCounter(0);
                                sourceToken.setFieldNumber(buttonMap.get(button).getNumber());
                                sourceToken.setIsInGarage(true);
                                sourceToken.setIsOnTheField(false);
                                listOfButtons.get(index).setStyle("-fx-base: #0090FF; "
                                                        + "-fx-background-radius: 50%;");
                                listOfButtons.get(index).setDisable(false);
                                listOfButtons.get(index).setOpacity(1);
                                break; 
                            }
                        }
                    }
                    if(sourceColor.equalsIgnoreCase("yellow"))
                    {
                        for(Button button : yellowButtons)
                        {
                            if(!buttonMap.get(button).isIsOccupied())
                            {
                                int index = listOfButtons.indexOf(button);
                                buttonMap.get(button).setIsOccupied(true);
                                buttonMap.get(button).setTokenID(tokenID);
                                board.getListOfFields().get(index).setIsOccupied(true);
                                board.getListOfFields().get(index).setTokenID(tokenID);
                                sourceToken.setCounter(0);
                                sourceToken.setFieldNumber(buttonMap.get(button).getNumber());
                                sourceToken.setIsInGarage(true);
                                sourceToken.setIsOnTheField(false);
                                listOfButtons.get(index).setStyle("-fx-base: #F6C900; "
                                                        + "-fx-background-radius: 50%;");
                                listOfButtons.get(index).setDisable(false);
                                listOfButtons.get(index).setOpacity(1);
                                break; 
                            }
                        }
                    }
                    if(sourceColor.equalsIgnoreCase("red"))
                    {
                        for(Button button : redButtons)
                        {
                            if(!buttonMap.get(button).isIsOccupied())
                            {
                                int index = listOfButtons.indexOf(button);
                                buttonMap.get(button).setIsOccupied(true);
                                buttonMap.get(button).setTokenID(tokenID);
                                board.getListOfFields().get(index).setIsOccupied(true);
                                board.getListOfFields().get(index).setTokenID(tokenID);
                                sourceToken.setCounter(0);
                                sourceToken.setFieldNumber(buttonMap.get(button).getNumber());
                                sourceToken.setIsInGarage(true);
                                sourceToken.setIsOnTheField(false);
                                listOfButtons.get(index).setStyle("-fx-base: #DE0600; "
                                                        + "-fx-background-radius: 50%;");
                                listOfButtons.get(index).setDisable(false);
                                listOfButtons.get(index).setOpacity(1);
                                break; 
                            }
                        }
                    }
                }
                break;
            }
            case "yellow": {
                if(buttonMap.get(button20).isIsOccupied())
                {
                    Integer tokenID = buttonMap.get(button20).getTokenID();
                    Token sourceToken = null; 
                    String sourceColor = null;
                    for (Player player : listOfPlayers.getPlayerList())
                    {
                        sourceColor = player.getColor();
                        sourceToken = player.getTokenById(tokenID);
                        if (sourceToken != null) break;
                    }
                    buttonMap.get(button20).setIsOccupied(false);
                    buttonMap.get(button20).setTokenID(null);
                    board.getListOfFields().get(20).setIsOccupied(false);
                    board.getListOfFields().get(20).setTokenID(null);
                    if(sourceColor.equalsIgnoreCase("blue"))
                    {
                        for(Button button : blueButtons)
                        {
                            if(!buttonMap.get(button).isIsOccupied())
                            {
                                int index = listOfButtons.indexOf(button);
                                buttonMap.get(button).setIsOccupied(true);
                                buttonMap.get(button).setTokenID(tokenID);
                                board.getListOfFields().get(index).setIsOccupied(true);
                                board.getListOfFields().get(index).setTokenID(tokenID);
                                sourceToken.setCounter(0);
                                sourceToken.setFieldNumber(buttonMap.get(button).getNumber());
                                sourceToken.setIsInGarage(true);
                                sourceToken.setIsOnTheField(false);
                                listOfButtons.get(index).setStyle("-fx-base: #0090FF; "
                                                        + "-fx-background-radius: 50%;");
                                listOfButtons.get(index).setDisable(false);
                                listOfButtons.get(index).setOpacity(1);
                                break; 
                            }
                        }
                    }
                    if(sourceColor.equalsIgnoreCase("green"))
                    {
                        for(Button button : greenButtons)
                        {
                            if(!buttonMap.get(button).isIsOccupied())
                            {
                                int index = listOfButtons.indexOf(button);
                                buttonMap.get(button).setIsOccupied(true);
                                buttonMap.get(button).setTokenID(tokenID);
                                board.getListOfFields().get(index).setIsOccupied(true);
                                board.getListOfFields().get(index).setTokenID(tokenID);
                                sourceToken.setCounter(0);
                                sourceToken.setFieldNumber(buttonMap.get(button).getNumber());
                                sourceToken.setIsInGarage(true);
                                sourceToken.setIsOnTheField(false);
                                listOfButtons.get(index).setStyle("-fx-base: #00B200; "
                                                        + "-fx-background-radius: 50%;");
                                listOfButtons.get(index).setDisable(false);
                                listOfButtons.get(index).setOpacity(1);
                                break; 
                            }
                        }
                    }
                    if(sourceColor.equalsIgnoreCase("red"))
                    {
                        for(Button button : redButtons)
                        {
                            if(!buttonMap.get(button).isIsOccupied())
                            {
                                int index = listOfButtons.indexOf(button);
                                buttonMap.get(button).setIsOccupied(true);
                                buttonMap.get(button).setTokenID(tokenID);
                                board.getListOfFields().get(index).setIsOccupied(true);
                                board.getListOfFields().get(index).setTokenID(tokenID);
                                sourceToken.setCounter(0);
                                sourceToken.setFieldNumber(buttonMap.get(button).getNumber());
                                sourceToken.setIsInGarage(true);
                                sourceToken.setIsOnTheField(false);
                                listOfButtons.get(index).setStyle("-fx-base: #DE0600; "
                                                        + "-fx-background-radius: 50%;");
                                listOfButtons.get(index).setDisable(false);
                                listOfButtons.get(index).setOpacity(1);
                                break; 
                            }
                        }
                    }
                }
                break;
            }
            case "red": {
                if(buttonMap.get(button30).isIsOccupied())
                {
                    Integer tokenID = buttonMap.get(button30).getTokenID();
                    Token sourceToken = null; 
                    String sourceColor = null;
                    for (Player player : listOfPlayers.getPlayerList())
                    {
                        sourceColor = player.getColor();
                        sourceToken = player.getTokenById(tokenID);
                        if (sourceToken != null) break;
                    }
                    buttonMap.get(button30).setIsOccupied(false);
                    buttonMap.get(button30).setTokenID(null);
                    board.getListOfFields().get(30).setIsOccupied(false);
                    board.getListOfFields().get(30).setTokenID(null);
                    if(sourceColor.equalsIgnoreCase("blue"))
                    {
                        for(Button button : blueButtons)
                        {
                            if(!buttonMap.get(button).isIsOccupied())
                            {
                                int index = listOfButtons.indexOf(button);
                                buttonMap.get(button).setIsOccupied(true);
                                buttonMap.get(button).setTokenID(tokenID);
                                board.getListOfFields().get(index).setIsOccupied(true);
                                board.getListOfFields().get(index).setTokenID(tokenID);
                                sourceToken.setCounter(0);
                                sourceToken.setFieldNumber(buttonMap.get(button).getNumber());
                                sourceToken.setIsInGarage(true);
                                sourceToken.setIsOnTheField(false);
                                listOfButtons.get(index).setStyle("-fx-base: #0090FF; "
                                                        + "-fx-background-radius: 50%;");
                                listOfButtons.get(index).setDisable(false);
                                listOfButtons.get(index).setOpacity(1);
                                break; 
                            }
                        }
                    }
                    if(sourceColor.equalsIgnoreCase("green"))
                    {
                        for(Button button : greenButtons)
                        {
                            if(!buttonMap.get(button).isIsOccupied())
                            {
                                int index = listOfButtons.indexOf(button);
                                buttonMap.get(button).setIsOccupied(true);
                                buttonMap.get(button).setTokenID(tokenID);
                                board.getListOfFields().get(index).setIsOccupied(true);
                                board.getListOfFields().get(index).setTokenID(tokenID);
                                sourceToken.setCounter(0);
                                sourceToken.setFieldNumber(buttonMap.get(button).getNumber());
                                sourceToken.setIsInGarage(true);
                                sourceToken.setIsOnTheField(false);
                                listOfButtons.get(index).setStyle("-fx-base: #00B200; "
                                                        + "-fx-background-radius: 50%;");
                                listOfButtons.get(index).setDisable(false);
                                listOfButtons.get(index).setOpacity(1);
                                break; 
                            }
                        }
                    }
                    if(sourceColor.equalsIgnoreCase("yellow"))
                    {
                        for(Button button : yellowButtons)
                        {
                            if(!buttonMap.get(button).isIsOccupied())
                            {
                                int index = listOfButtons.indexOf(button);
                                buttonMap.get(button).setIsOccupied(true);
                                buttonMap.get(button).setTokenID(tokenID);
                                board.getListOfFields().get(index).setIsOccupied(true);
                                board.getListOfFields().get(index).setTokenID(tokenID);
                                sourceToken.setCounter(0);
                                sourceToken.setFieldNumber(buttonMap.get(button).getNumber());
                                sourceToken.setIsInGarage(true);
                                sourceToken.setIsOnTheField(false);
                                listOfButtons.get(index).setStyle("-fx-base: #F6C900; "
                                                        + "-fx-background-radius: 50%;");
                                listOfButtons.get(index).setDisable(false);
                                listOfButtons.get(index).setOpacity(1);
                                break; 
                            }
                        }
                    }
                }
                break;
            }
        }
    }
    
    private boolean isStartingFieldClear(Player sourcePlayer)
    {
        String color = sourcePlayer.getColor();
        Integer tokenID = null;
        switch(color) {
            case "blue": {
                if(this.board.getListOfFields().get(0).isIsOccupied())
                    tokenID = this.board.getListOfFields().get(0).getTokenID();
                break;
            }
            case "green": {
                if(this.board.getListOfFields().get(10).isIsOccupied())
                    tokenID = this.board.getListOfFields().get(10).getTokenID();
                break;
            }
            case "yellow": {
                if(this.board.getListOfFields().get(20).isIsOccupied())
                    tokenID = this.board.getListOfFields().get(20).getTokenID();
                break;
            }
            case "red": {
                if(this.board.getListOfFields().get(30).isIsOccupied())
                    tokenID = this.board.getListOfFields().get(30).getTokenID();
                break;
            }
        }
         if(tokenID != null)
        {
        String tokenColor = null;
        for (Player player : listOfPlayers.getPlayerList())
        {
            tokenColor = player.getColor();
            if(player.getTokenById(tokenID) != null) break;
        }
       
            if(color.equalsIgnoreCase(tokenColor))
                return false;
            else 
                return true;
        }
        else 
            return true;
    }
    
    public void setNextActive(String color)
    {
        switch(color.toLowerCase())
        {
            case "blue": {
                this.listOfPlayers.getPlayer(0).setIsMyTurn(false);
                this.listOfPlayers.getPlayer(1).setIsMyTurn(true);
                this.bluePlayerArrow.setVisible(false);
                this.greenPlayerArrow.setVisible(true);
                break;
            }
            case "green": {
                this.listOfPlayers.getPlayer(1).setIsMyTurn(false);
                this.listOfPlayers.getPlayer(2).setIsMyTurn(true);
                this.greenPlayerArrow.setVisible(false);
                this.yellowPlayerArrow.setVisible(true);
                break;
            }
            case "yellow": {
                this.listOfPlayers.getPlayer(2).setIsMyTurn(false);
                this.listOfPlayers.getPlayer(3).setIsMyTurn(true);
                this.yellowPlayerArrow.setVisible(false);
                this.redPlayerArrow.setVisible(true);
                break;
            }
            case "red": {
                this.listOfPlayers.getPlayer(3).setIsMyTurn(false);
                this.listOfPlayers.getPlayer(0).setIsMyTurn(true);
                this.redPlayerArrow.setVisible(false);
                this.bluePlayerArrow.setVisible(true);
                break;
            }
        }
    }
    
    public void setActive(String color)
    {
        this.listOfPlayers.getPlayer(0).setIsMyTurn(false);
        this.listOfPlayers.getPlayer(1).setIsMyTurn(false);
        this.listOfPlayers.getPlayer(2).setIsMyTurn(false);
        this.listOfPlayers.getPlayer(3).setIsMyTurn(false);
        this.bluePlayerArrow.setVisible(false);
        this.greenPlayerArrow.setVisible(false);
        this.yellowPlayerArrow.setVisible(false);
        this.redPlayerArrow.setVisible(false);
        switch(color.toLowerCase())
        {
            case "blue": {
                this.listOfPlayers.getPlayer(0).setIsMyTurn(true);
                this.bluePlayerArrow.setVisible(true);
                break;
            }
            case "green": {
                this.listOfPlayers.getPlayer(1).setIsMyTurn(true);
                this.greenPlayerArrow.setVisible(true);
                break;
            }
            case "yellow": {
                this.listOfPlayers.getPlayer(2).setIsMyTurn(true);
                this.yellowPlayerArrow.setVisible(true);
                break;
            }
            case "red": {
                this.listOfPlayers.getPlayer(3).setIsMyTurn(true);
                this.redPlayerArrow.setVisible(true);
                break;
            }
        }
    }

    public void setPlayerList(PlayerList listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }
    
    public void setBoard(Board board) {
        this.board = board;
        for(Button button : listOfButtons) {
            button.setDisable(true);
            button.setOpacity(0);
        }
        for(Field field : board.getListOfFields()) 
        {
            if(field.isIsOccupied()){
                int tokenId = field.getTokenID();
                int number = field.getNumber();
                String color = null;
                for(Player player : listOfPlayers.getPlayerList()) {
                    color = player.getColor();
                    if(player.getTokenById(tokenId) != null)
                        break;
                }
                buttonMap.get(listOfButtons.get(number)).setIsOccupied(true);
                buttonMap.get(listOfButtons.get(number)).setTokenID(tokenId);
                switch(color) {
                    case "blue":
                        listOfButtons.get(number).setStyle("-fx-base: #0090FF; "
                                                        + "-fx-background-radius: 50%;");
                        listOfButtons.get(number).setDisable(false);
                        listOfButtons.get(number).setOpacity(1);
                        break;
                    case "green":
                        listOfButtons.get(number).setStyle("-fx-base: #00B200; "
                                                        + "-fx-background-radius: 50%;");
                        listOfButtons.get(number).setDisable(false);
                        listOfButtons.get(number).setOpacity(1);
                        break;
                    case "yellow":
                        listOfButtons.get(number).setStyle("-fx-base: #F6C900; "
                                                        + "-fx-background-radius: 50%;");
                        listOfButtons.get(number).setDisable(false);
                        listOfButtons.get(number).setOpacity(1);
                        break;
                    case "red":
                        listOfButtons.get(number).setStyle("-fx-base: #DE0600; "
                                                        + "-fx-background-radius: 50%;");
                        listOfButtons.get(number).setDisable(false);
                        listOfButtons.get(number).setOpacity(1);
                        break;
                }
            }
        }
    }
    

}
