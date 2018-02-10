
package ludo;

/**
 *
 * @author Mateusz
 */
public class Field {
    
    private boolean isOccupied = false;
    private Integer number;
    private Integer tokenID;
    
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
    
}
