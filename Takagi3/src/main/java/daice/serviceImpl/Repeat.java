package daice.serviceImpl;

import daice.service.DaiceService;
import daice.constants.Constants;
import daice.dto.Human;
import daice.dto.character.Character;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repeat implements DaiceService {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void repeatBattle() throws IOException{
		boolean judge = true;
		//�L�����N�^�[����
		Character myCharacter = Human.createMyCharacter();
		Character enemyCharacter = Human.createEnemyCharacter();
		//�o�g���J��Ԃ�
		while(judge) {
			Constants.Message.MESSAGE_LINE01.showMessage();
			Constants.Message.MESSAGE_TURN01.showMessage();
			Constants.Message.MESSAGE_MY_HP01.showMessage();
			myCharacter.displayHp();
			Constants.Message.MESSAGE_ENEMY_HP01.showMessage();
			enemyCharacter.displayHp();

			//�T�C�R���̐���I���i�����̃^�[���j
			Constants.Message.MESSAGE01.showMessage();
			String daiceNumber = bufferedReader.readLine();
			switch(daiceNumber) {
			case"3":
				myCharacter.threeAttack(enemyCharacter);
				break;
			case"2":
				myCharacter.twiceAttack(enemyCharacter);
				break;
			case"1":
				myCharacter.onceAttack(enemyCharacter);
				break;
			}
			judge = enemyCharacter.judgementBattle();
			//����̃^�[��
			Constants.Message.MESSAGE_ENEMY_HP02.showMessage();
			enemyCharacter.displayHp();
			Constants.Message.MESSAGE_TURN02.showMessage();
			enemyCharacter.attack(myCharacter);
			judge = myCharacter.judgementBattle();
			Constants.Message.MESSAGE_MY_HP02.showMessage();
			myCharacter.displayHp();
		}
	}
}