package daice.dto;
import daice.dto.character.Character;
import daice.dto.character.EnemyCharacter;
import daice.dto.character.MyCharacter;

public interface Human{
	public static Character createMyCharacter() {
		Character myCharacter = new MyCharacter(100, "");
		return myCharacter;
	}
	public static Character createEnemyCharacter() {
		Character enemy = new EnemyCharacter(100, "");
		return enemy;
	}
}