package ludo.client;

/**
 *
 * @author Mateusz
 */
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum PlayerColor implements Serializable {
	Blue(0),
	Green(1),
        Yellow(2),
        Red(3);

	private final int value;

	private static Map<Integer, PlayerColor> map = new HashMap<Integer, PlayerColor>();

    static {
        for (PlayerColor colorEnum : PlayerColor.values()) {
            map.put(colorEnum.value, colorEnum);
        }
    }

    public static PlayerColor valueOf(int color) {
        return map.get(color);
    }

	PlayerColor(int val){
		this.value = val;
	}

	public int getValue(){
		return this.value;
	}
}
