
package ludo.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateusz
 */
public class Player implements Serializable{
    private String color;
    private List<Token> tokenList;
    private boolean isMyTurn = false;
    private String name;
    private Integer id;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.tokenList = new ArrayList<>(); //Tworzę nową listę pionków
        //Dodaje cztery pionki do listy
        for (int i = 0; i < 4; i++) {
            tokenList.add(new Token());
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    public void setTokenList(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    public boolean isIsMyTurn() {
        return isMyTurn;
    }

    public void setIsMyTurn(boolean isMyTurn) {
        this.isMyTurn = isMyTurn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Token getTokenById(int id)
    {
        for (Token token : tokenList) 
        {
            if (token.getId() == id) return token;
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
}
