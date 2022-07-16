package GameUtils;

import java.util.Random;

public class GameUtils {

	public static final Random random = new Random();
	
	public int throwDice() {
		return random.nextInt(6) + 1;
	}
	
}
