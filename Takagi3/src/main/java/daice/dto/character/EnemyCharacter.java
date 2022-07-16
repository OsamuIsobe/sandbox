package daice.dto.character;
import java.util.ArrayList;
import java.util.List;

import GameUtils.GameUtils;
import daice.Contexst.GameConfig;
import daice.constants.Constants;
import daice.constants.Constants.Message;


public class EnemyCharacter extends Character {
	
	GameUtils gameUtils = new GameUtils();
	
	int hp;
	String name;
	
	public EnemyCharacter(int hp, String name) {
		super(hp, name);
	}
	//�T�C�R���U��
	public void attack(Character myCharacter) {
		Constants.Message.MESSAGE_DAICE_DISPLAY01.showMessage();
		// �T�C�R���̌����Q�[���̐ݒ�N���X�ŕێ�����
		// �T�C�R���̒l��for���̊O��List�����A�����ɑ�����Ă����B
		List<Integer> diceResultList = new ArrayList<Integer>();
		for(int i = 0; i < GameConfig.usingDiceNum; i++) {
			// gameUtils�N���X�ɏo�ڂ��擾���郁�\�b�h����邱�ƂŁAramdom���\�b�h�̌Ăяo���񐔂����炷�B
			diceResultList.add(gameUtils.throwDice());
		}
		// StreamAPI���g�����ƂŃ_�C�X�̖ڂ̏o�͂�1�s�ŏ�����
		diceResultList.stream().forEach(e -> System.out.print(e + " "));
		// �o���ڂɉ����ă_���[�W��^����
		attackCharacter(diceResultList, myCharacter);
//		Random random = new Random();
//		int firstDaice = random.nextInt(6) + 1;
//		int secondDaice = random.nextInt(6) + 1;
//		int thirdDaice = random.nextInt(6) + 1;
//		System.out.print(firstDaice + ",");
//		System.out.print(secondDaice + ",");
//		System.out.print(thirdDaice + "\n");
//		//�]���ڂ������ꍇ
//		if(firstDaice == secondDaice && firstDaice == thirdDaice && secondDaice == thirdDaice){
//			Constants.Message.MESSAGE_DOUBLET_ENEMY.showMessage();
//			myCharacter.setHp(0);
//		}else{
//		int totalNum = firstDaice + secondDaice + thirdDaice;
//		myCharacter.setHp(myCharacter.getHp() - totalNum);
//		System.out.print(totalNum);
//		Constants.Message.MESSAGE_DAMAGE.showMessage();
//		}
	}
	// ���̃N���X�ł����g��Ȃ��悤�ȃ��\�b�h��private�ɂ��đ��̃N���X�Ŏg���Ȃ�
	// �悤�ɂ��A���N���X���Œ�`����B���\�b�h�ɂ��ČĂяo�����ƂŁA�\�[�X�̗����
	// �ǂ݂₷������
	/**
	 * �T�C�R���̏o���ڂ̍��v�l���A����Ƀ_���[�W��^����B
	 * �]���ڂ̏ꍇ�́A����̃��C�t��0�ɂ���B
	 * @param diceList �T�C�R���̏o�ڂ̃��X�g
	 * @param myCharacter ����L�����N�^�[
	 */
	public void attackCharacter(List<Integer> diceList, Character myCharacter) {
		// �_�C�X�̈꓊�ڂƂ��ׂĂ̗v�f�����������������ꍇ��true��Ԃ��B
		boolean flg = diceList.stream().allMatch(e -> e.equals(diceList.get(0)));
		if(flg) {
			myCharacter.setHp(0);
			// showMessage�̈������ϒ��ɂ��Ă���̂ŁA�����̌�������Ă��A
			//�@�������\�b�h�Ń��b�Z�[�W���Ăяo����B
			Message.MESSAGE_DOUBLET_ENEMY.showMessage();
		} else {
			int totalNum = diceList.stream().mapToInt(e -> e).sum();
			myCharacter.setHp(myCharacter.getHp() - totalNum);
			// showMessage�̈������ϒ��ɂ��Ă���̂ŁA�����̌�������Ă��A
			//�@�������\�b�h�Ń��b�Z�[�W���Ăяo����B
			Message.MESSAGE_DAMAGE.showMessage(totalNum);
		}
	}

}