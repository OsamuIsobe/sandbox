package daice.dto.character;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.Test;

public class EnemyCharacterTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		EnemyCharacter enemyCharacter = new EnemyCharacter(100, "���Y");
		Character character = new Character(30, "����");
		int total = enemyCharacter.attackCharacter(
				Arrays.asList(3,4,5), character);
		int expected = 11;
		int actual = total;
		assertThat(expected, is(actual));
	}

}
