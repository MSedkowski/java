package ludo.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Mateusz
 */
public class Board implements Serializable{

    private PlayerList listOfPlayers;
    private boolean isOver = false;
    private List<Field> listOfFields;

    public Board(PlayerList listOfPlayers) {
        this.listOfPlayers = listOfPlayers; //Przepisuje graczy
        this.listOfFields = new ArrayList<>(); //Tworzę nową listę pól planszy
        
        //Dodaje pola z odpowiednimi atrybutami
        //Najpierw startowe i zwykłe
        int number = 0;
        for (int i = 1; i < 5; i++) {
            this.listOfFields.add(new Field(number)); //Startowe
            number++;
            for (int j = 0; j < 9; j++, number++) {
                this.listOfFields.add(new Field(number)); //Zwykłe
            }
        }
        //Końcowe
        for (int i = 5; i < 9; i++) {
            for (int j = 0; j < 4; j++, number++) {
                this.listOfFields.add(new Field(number));
            }
        }
        
        //Garaże
        for (int i = 9; i < 13; i++) {
            for (int j = 0; j < 4; j++, number++) {
                this.listOfFields.add(new Field(number));
            }
        }
        
        //Ustawiam pionki na pozycjach startowych
        for (int i = 0; i < listOfPlayers.getPlayerList().size(); i++) {
            Token token = this.listOfPlayers.getPlayer(i).getTokenList().get(0);
            setTokenOnStartField(token);
        }
        
        //Ustawiam pionki w garażu
        int field = 57, j;
        for(int i = 0; i < listOfPlayers.getPlayerList().size(); i++) {
            for(j = 1; j < 4; j++, field++) {
                this.listOfFields.get(field).setTokenID(this.listOfPlayers.getPlayer(i).getTokenList().get(j).getId());
                this.listOfFields.get(field).setIsOccupied(true);
                this.listOfFields.get(field).setTokenColor(this.listOfPlayers.getPlayer(i).getColor());
            }
            field++;
        }
        
        //Ustawiam active na 1 gracza
        listOfPlayers.getPlayer(0).setIsMyTurn(true);
    }

    public int rollDice() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    public void setTokenOnStartField(Token token)
    {
        token.setOnStartField();
        Field startField = null;
        switch(token.getColor()) {
            case "blue":{
                startField = listOfFields.get(0);
                break;
            }
            case "green":{
                startField = listOfFields.get(10);
                break;
            }
            case "yellow":{
                startField = listOfFields.get(20);
                break;
            }
            case "red":{
                startField = listOfFields.get(30);
                break;
            }
        }
        startField.setIsOccupied(true);
        startField.setTokenID(token.getId());
        startField.setTokenColor(token.getColor());
    }
    
    public void moveTokenFromGarage(Token token) {
        int fieldNumber = token.getFieldNumber();
        listOfFields.get(fieldNumber).setIsOccupied(false);
        listOfFields.get(fieldNumber).setTokenID(null);
        listOfFields.get(fieldNumber).setTokenColor(null);
        setTokenOnStartField(token);
    }

    public List<Field> getListOfFields() {
        return listOfFields;
    }
    
    public boolean checkIfStartFieldIsClear(Token token) {
        switch(token.getColor()) {
            case "blue": 
                return !(listOfFields.get(0).isIsOccupied() && listOfFields.get(0).getTokenColor().equalsIgnoreCase(token.getColor()));
            case "green":
                return !(listOfFields.get(10).isIsOccupied() && listOfFields.get(10).getTokenColor().equalsIgnoreCase(token.getColor()));
            case "yellow":
                return !(listOfFields.get(20).isIsOccupied() && listOfFields.get(20).getTokenColor().equalsIgnoreCase(token.getColor()));
            case "red":
                return !(listOfFields.get(30).isIsOccupied() && listOfFields.get(30).getTokenColor().equalsIgnoreCase(token.getColor()));
        }
        return true;
    }
    
    public boolean checkIfMovePossible(Token token, int diceRoll) {
        int fieldNumber;
        if(token.getFieldNumber() + diceRoll > 39)
            fieldNumber = token.getFieldNumber() + diceRoll - 40;
        else 
            fieldNumber = token.getFieldNumber() + diceRoll;
        return !(listOfFields.get(fieldNumber).isIsOccupied() && listOfFields.get(fieldNumber).getTokenColor().equalsIgnoreCase(token.getColor()));
    }
    
    public void removeTokenFromEndField(Token token, int diceRoll) {
        Field endField = listOfFields.get(token.getFieldNumber() + diceRoll);
        if(endField.isIsOccupied() && !endField.getTokenColor().equalsIgnoreCase(token.getColor())) {
            int id = endField.getTokenID();
            Token removedToken = null;
            for(Player player : listOfPlayers.getPlayerList()) {
                removedToken = player.getTokenById(id);
                if(removedToken != null)
                    break;
            }
            returnToGarage(removedToken);
        }            
    }
    
    public void removeTokenFromStartField(Token sourceToken) {
        Field startField = null;
        switch(sourceToken.getColor()) {
            case "blue": 
                startField = listOfFields.get(0);
                break;
            case "green": 
                startField = listOfFields.get(10);
                break;
            case "yellow": 
                startField = listOfFields.get(20);
                break;
            case "red": 
                startField = listOfFields.get(30);
                break;
        }
        if(startField.getTokenID() != null){
            int tokenId = startField.getTokenID();
        Token removedToken = null;
        for(Player player : listOfPlayers.getPlayerList()) {
            removedToken = player.getTokenById(tokenId);
            if(removedToken != null)
                break;
        }
        returnToGarage(removedToken);
        }
    }
    
    public void returnToGarage(Token token) {
        token.setCounter(0);
        token.setIsInGarage(true);
        token.setIsOnTheField(false);
        int field = 0;
        switch(token.getColor()) {
            case "blue": 
                for(field = 59; field > 55; field--) {
                    if(!listOfFields.get(field).isIsOccupied()){
                        break;
                    }
                }
                break;
            case "green": 
                for(field = 63; field > 59; field--) {
                    if(!listOfFields.get(field).isIsOccupied()){
                        break;
                    }
                }
                break;
            case "yellow": 
                for(field = 67; field > 63; field--) {
                    if(!listOfFields.get(field).isIsOccupied()){
                        break;
                    }
                }
                break;
            case "red": 
                for(field = 71; field > 67; field--) {
                    if(!listOfFields.get(field).isIsOccupied()){
                        break;
                    }
                }
                break;
        }
        listOfFields.get(field).setIsOccupied(true);
        listOfFields.get(field).setTokenID(token.getId());
        listOfFields.get(field).setTokenColor(token.getColor());
        token.setFieldNumber(field);
    }
    
    public boolean makeMove(Token token, int diceRoll) {
        if(token.isIsInGarage() && (diceRoll == 1 || diceRoll == 6)) {
            if(checkIfStartFieldIsClear(token)) {
                removeTokenFromStartField(token);
                moveTokenFromGarage(token);
                nextPlayerTurn();
                return true;
            }
        }
        else if(token.isIsOnTheField()) {
            if(token.getCounter() + diceRoll < 40) {
                if(checkIfMovePossible(token, diceRoll)) {
                    removeTokenFromEndField(token, diceRoll);
                    moveToken(token, diceRoll);
                    nextPlayerTurn();
                    return true;
                }
            }
            else {
                takeToWinningField(token);
                nextPlayerTurn();
                return true;
            }
        }
        return false;
    }
    
    public void moveToken(Token token, int diceRoll) {
        int fieldNumber;
        if(token.getFieldNumber() + diceRoll > 39)
            fieldNumber = token.getFieldNumber() + diceRoll - 40;
        else 
            fieldNumber = token.getFieldNumber() + diceRoll;
        Field sourceField = listOfFields.get(token.getFieldNumber());
        Field endField = listOfFields.get(fieldNumber);
        sourceField.setIsOccupied(false);
        sourceField.setTokenColor(null);
        sourceField.setTokenID(null);
        token.setFieldNumber(fieldNumber); 
        token.setCounter(token.getCounter() + diceRoll);
        endField.setIsOccupied(true);
        endField.setTokenID(token.getId());
        endField.setTokenColor(token.getColor());
    }
    
    public void takeToWinningField(Token token) {
        Field startField = listOfFields.get(token.getFieldNumber());
        startField.setIsOccupied(false);
        startField.setTokenID(null);
        startField.setTokenColor(null);
        int field = 0;
        switch(token.getColor()) {
            case "blue": 
                for(field = 44; field > 39; field--) {
                    if(!listOfFields.get(field).isIsOccupied()){
                        break;
                    }
                }
            case "green": 
                for(field = 48; field > 44; field--) {
                    if(!listOfFields.get(field).isIsOccupied()){
                        break;
                    }
                }
            case "yellow": 
                for(field = 52; field > 48; field--) {
                    if(!listOfFields.get(field).isIsOccupied()){
                        break;
                    }
                }
            case "red": 
                for(field = 56; field > 52; field--) {
                    if(!listOfFields.get(field).isIsOccupied()){
                        break;
                    }
                }
        }
        Field endField = listOfFields.get(field);
        endField.setIsOccupied(true);
        endField.setTokenColor(token.getColor());
        endField.setTokenID(token.getId());
        token.setIsOnTheField(false);
        token.setIsOnWinningField(true);
        token.setFieldNumber(field);
    }
    
    public void nextPlayerTurn() {
        Player activePlayer = null;
        for(Player player : listOfPlayers.getPlayerList()) {
            activePlayer = player;
            if(player.isIsMyTurn())
                break;
        }
        activePlayer.setIsMyTurn(false);
        int index = listOfPlayers.getPlayerList().indexOf(activePlayer);
        if(index == listOfPlayers.getPlayerList().size() - 1)
            listOfPlayers.getPlayerList().get(0).setIsMyTurn(true);
        else
            listOfPlayers.getPlayerList().get(index + 1).setIsMyTurn(true);
    }

    public PlayerList getListOfPlayers() {
        return listOfPlayers;
    }

    public void setListOfPlayers(PlayerList listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }
    
    
}
