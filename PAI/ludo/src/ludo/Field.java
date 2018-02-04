
package ludo;

/**
 *
 * @author Mateusz
 */
public class Field {
    private boolean isGreenStartField = false;
    private boolean isYellowStartField = false;
    private boolean isRedStartField = false;
    private boolean isBlueStartField = false;
    private boolean isGreenEndField = false;
    private boolean isYellowEndField = false;
    private boolean isRedEndField = false;
    private boolean isBlueEndField = false;
    
    private boolean isOccupied = false;
    private int number;
    private int tokenID;
    
    public Field(int number) {
        this.number = number;
    }
    
    public Field(int number, int option) {
        this.number = number;
        switch(option){
            case 1: {
                setIsBlueStartField(true);
                break;
            }
            case 2: {
                setIsGreenStartField(true);
                break;
            }
            case 3: {
                setIsRedStartField(true);
                break;
            }
            case 4: {
                setIsYellowStartField(true);
                break;
            }
            case 5: {
                setIsBlueEndField(true);
                break;
            }
            case 6: {
                setIsGreenEndField(true);
                break;
            }
            case 7: {
                setIsRedEndField(true);
                break;
            }
            case 8: {
                setIsYellowEndField(true);
                break;
            }
            default : {
                break;
            }
        }
    }

    public boolean isIsGreenStartField() {
        return isGreenStartField;
    }

    public void setIsGreenStartField(boolean isGreenStartField) {
        this.isGreenStartField = isGreenStartField;
    }

    public boolean isIsYellowStartField() {
        return isYellowStartField;
    }

    public void setIsYellowStartField(boolean isYellowStartField) {
        this.isYellowStartField = isYellowStartField;
    }

    public boolean isIsRedStartField() {
        return isRedStartField;
    }

    public void setIsRedStartField(boolean isRedStartField) {
        this.isRedStartField = isRedStartField;
    }

    public boolean isIsBlueStartField() {
        return isBlueStartField;
    }

    public void setIsBlueStartField(boolean isBlueStartField) {
        this.isBlueStartField = isBlueStartField;
    }

    public boolean isIsGreenEndField() {
        return isGreenEndField;
    }

    public void setIsGreenEndField(boolean isGreenEndField) {
        this.isGreenEndField = isGreenEndField;
    }

    public boolean isIsYellowEndField() {
        return isYellowEndField;
    }

    public void setIsYellowEndField(boolean isYellowEndField) {
        this.isYellowEndField = isYellowEndField;
    }

    public boolean isIsRedEndField() {
        return isRedEndField;
    }

    public void setIsRedEndField(boolean isRedEndField) {
        this.isRedEndField = isRedEndField;
    }

    public boolean isIsBlueEndField() {
        return isBlueEndField;
    }

    public void setIsBlueEndField(boolean isBlueEndField) {
        this.isBlueEndField = isBlueEndField;
    }

    public boolean isIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTokenID() {
        return tokenID;
    }

    public void setTokenID(int tokenID) {
        this.tokenID = tokenID;
    }
    
    
}
