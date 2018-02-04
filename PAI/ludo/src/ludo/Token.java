package ludo;

import java.util.Random;

/**
 *
 * @author Mateusz
 */
public class Token {
    private int id;
    private boolean isOnTheField = false;
    private boolean isInGarage = true;
    private boolean isOnWinningField = false;
    private int counter;
    private int fieldNumber;

    public Token() {
        this.counter = 0;
        Random rand = new Random();
        this.id = rand.nextInt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsOnTheField() {
        return isOnTheField;
    }

    public void setIsOnTheField(boolean isOnTheField) {
        this.isOnTheField = isOnTheField;
    }

    public boolean isIsInGarage() {
        return isInGarage;
    }

    public void setIsInGarage(boolean isInGarage) {
        this.isInGarage = isInGarage;
    }

    public boolean isIsOnWinningField() {
        return isOnWinningField;
    }

    public void setIsOnWinningField(boolean isOnWinningField) {
        this.isOnWinningField = isOnWinningField;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }
    
    public void setOnStartField(int fieldNumber) {
        this.fieldNumber = fieldNumber;
        this.setIsOnTheField(true);
        this.setIsInGarage(false);
    }
    
    
}
