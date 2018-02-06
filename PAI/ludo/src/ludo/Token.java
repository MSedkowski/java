package ludo;

import static java.lang.Math.abs;
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
    private static int referenceCounter = 0;

    public Token() {
        this.counter = 0;
        this.id = referenceCounter;
        referenceCounter++;
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
    
    public void setOnStartField(String color) {
        switch(color){
            case "blue": {
                this.fieldNumber = 0;
                break;
            }
            case "green": {
                this.fieldNumber = 10;
                break;
            }
            case "yellow":{
                this.fieldNumber = 20;
                break;
            }
            case "red": {
                this.fieldNumber = 30;
                break;
            }
        }
        this.setIsOnTheField(true);
        this.setIsInGarage(false);
        this.counter = 0;
    }
    
    
}
