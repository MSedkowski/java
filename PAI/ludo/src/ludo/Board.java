package ludo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Mateusz
 */
public class Board {

    private PlayerList listOfPlayers;
    private boolean isOver = false;
    private List<Field> listOfFields;

    public Board(PlayerList listOfPlayers) {
        this.listOfPlayers = listOfPlayers; //Przepisuje graczy
        this.listOfFields = new ArrayList<>(); //Tworzę nową listę pól planszy
        
        //Dodaje pola z odpowiednimi atrybutami
        //Najpierw startowe i zwykłe
        int number = 1;
        for (int i = 1; i < 5; i++, number++) {
            this.listOfFields.add(new Field(number, i)); //Startowe
            for (int j = 0; j < 8; j++, number++) {
                this.listOfFields.add(new Field(number)); //Zwykłe
            }
        }
        
        //Końcowe
        for (int i = 5; i < 9; i++, number++) {
            for (int j = 0; j < 4; j++, number++) {
                this.listOfFields.add(new Field(number, i));
            }
        }
        
        //Ustawiam pionki na pozycjach startowych
        for (int i = 0; i < 4; i++) {
            this.listOfPlayers.getPlayer(i).getTokenList().get(0).setOnStartField(i*10);
            int id = this.listOfPlayers.getPlayer(i).getTokenList().get(0).getId();
            this.listOfFields.get(i*10).setTokenID(id);
            this.listOfFields.get(i*10).setIsOccupied(true);
        }

    }
    
    public void moveToken(int diceRoll, Player player, Token token)
    {
        
        Token moveToken = player.getTokenById(token.getId());
        removeIfOccupied(moveToken.getFieldNumber() + diceRoll);
        moveToken.setCounter(moveToken.getCounter() + diceRoll);
        moveToken.setFieldNumber(moveToken.getFieldNumber() + diceRoll);
    }

    public int rollDice() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
    
    public void removeIfOccupied(int fieldNumber)
    {
        if (this.listOfFields.get(fieldNumber).isIsOccupied())
        {
            int id = this.listOfFields.get(fieldNumber).getTokenID();
            for (Player searchPlayer : listOfPlayers.getPlayerList())
            {
                Token searchToken = searchPlayer.getTokenById(id);
                if (searchToken != null)
                {
                    searchToken.setFieldNumber(370); //Ustawiam w garażu DO ZROBIENIA
                    searchToken.setIsInGarage(true);
                    searchToken.setIsOnTheField(false);
                    searchToken.setCounter(0);
                    break;
                }
            }
        } 
    }
}
