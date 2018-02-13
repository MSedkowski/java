
package ludo.common;

import java.io.Serializable;

/**
 *
 * @author Mateusz
 */
public class Field implements Serializable{
    
    private boolean isOccupied = false;
    private Integer number;
    private Integer tokenID;
    private String tokenColor;
    
    public Field(int number) {
        this.number = number;
    }

    public boolean isIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Integer getTokenID() {
        return tokenID;
    }

    public void setTokenID(Integer tokenID) {
        this.tokenID = tokenID;
    }

    public String getTokenColor() {
        return tokenColor;
    }

    public void setTokenColor(String tokenColor) {
        this.tokenColor = tokenColor;
    }
    
}
