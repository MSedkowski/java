
package ludo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateusz
 */
public class PlayerList {
    private List<Player> playerList = new ArrayList<>();
    
    public PlayerList(){
        
    }
    
    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
    
    public void addPlayer(Player player) {
        this.playerList.add(player);
    }
    
    public void removePlayer(Player player) {
        this.playerList.remove(player);
    }
    
    public Player getPlayer(int number) {
        return this.playerList.get(number);
    }
    
    public Player searchPlayerByName(String name) {
        for(Player player : this.playerList) {
            if(player.getName().equalsIgnoreCase(name))
                return player;
        }
        return null;
    }
}
