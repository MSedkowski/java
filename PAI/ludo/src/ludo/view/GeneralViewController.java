/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludo.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import ludo.Board;
import ludo.Chinczyk;
import ludo.Field;
import ludo.Player;
import ludo.PlayerList;

/**
 * FXML Controller class
 *
 * @author Mateusz
 */
public class GeneralViewController {
 
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
    private int diceRoll;
    private Chinczyk chinczyk;
    private HashMap<Button, Field> buttonMap;
    private List<Button> listOfButtons;
    
    
    public void initialize() {
        
    }    
    
    public void setChinczyk(Chinczyk chinczyk, Board board, PlayerList listOfPlayers) {
        this.chinczyk = chinczyk;
        this.board = board;
        this.listOfPlayers = listOfPlayers;
        createListOfButtons();
        initializeListOfPlayers();
        initializeListOfFields();
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
    
    public void initializeListOfPlayers()
    {
        this.bluePlayer.setText(listOfPlayers.getPlayer(0).getName());
        this.greenPlayer.setText(listOfPlayers.getPlayer(1).getName());
        this.yellowPlayer.setText(listOfPlayers.getPlayer(2).getName());
        this.redPlayer.setText(listOfPlayers.getPlayer(3).getName());
        listOfPlayers.getPlayer(0).setIsMyTurn(true);
        this.bluePlayerArrow.setVisible(true);
    }
    
    public void initializeListOfFields()
    {
        this.buttonMap = new HashMap<>();
        int i = 0;
        for(Field field : board.getListOfFields())
        {
            this.buttonMap.put(listOfButtons.get(i), field);
            i++;
        }
        for (i = 0; i < 72; i++)
        {
            listOfButtons.get(i).opacityProperty().set(0);
            listOfButtons.get(i).setDisable(true);
        }
        setTokens();
        
    }
    
    public void setTokens()
    {
        int blueTokens[] = {0,57,58,59};
        int greenTokens[] = {10,61,62,63};
        int yellowTokens[] = {20,65,66,67};
        int redTokens[] = {30,69,70,71};
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
        
    }
    
    public void handleRollDiceButton(ActionEvent event) 
    {
        this.diceRoll = board.rollDice();
        this.rollDiceLabel.setText("" + diceRoll);
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
        setActive(color);
    }
    
    public void setActive(String color)
    {
        switch(color)
        {
            case "blue": {
                this.listOfPlayers.getPlayer(1).setIsMyTurn(true);
                this.bluePlayerArrow.setVisible(false);
                this.greenPlayerArrow.setVisible(true);
                break;
            }
            case "green": {
                this.listOfPlayers.getPlayer(2).setIsMyTurn(true);
                this.greenPlayerArrow.setVisible(false);
                this.yellowPlayerArrow.setVisible(true);
                break;
            }
            case "yellow": {
                this.listOfPlayers.getPlayer(3).setIsMyTurn(true);
                this.yellowPlayerArrow.setVisible(false);
                this.redPlayerArrow.setVisible(true);
                break;
            }
            case "red": {
                this.listOfPlayers.getPlayer(0).setIsMyTurn(true);
                this.redPlayerArrow.setVisible(false);
                this.bluePlayerArrow.setVisible(true);
                break;
            }
        }
    }
    
}
