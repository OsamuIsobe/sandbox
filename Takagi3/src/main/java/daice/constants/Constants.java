package daice.constants;

import java.text.MessageFormat;
import java.util.Random;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class Constants{

	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	public enum Message {
		//��{�o��
		MESSAGE01("\n" +"�T�C�R���̐�����͂��Ă�������"),
		MESSAGE02("�I�����܂���"),
		//���C�A�E�g
		MESSAGE_LINE01("--------------------------------------------"),
		//�^�[���o��
		MESSAGE_TURN01("�����̃^�[��"),
		MESSAGE_TURN02("\n" + "����̃^�[��"),
		//�T�C�R���̐�
		MESSAGE_DAICE_DISPLAY01("�o���ڂ̐�"),
		MESSAGE_DAICE_QUANTITY01("�_�C�X1��\n�E����錾���Ă�������"),
		MESSAGE_DAICE_QUANTITY01_01("�錾������"),
		MESSAGE_DAICE_QUANTITY02("�_�C�X2��"),
		MESSAGE_DAICE_QUANTITY03("�_�C�X�R��"),
		//�]����
		MESSAGE_DOUBLET_MYCHARACTER("�]���ڂ��o���̂�50�_���[�W"),
		MESSAGE_DOUBLET_ENEMY("�]���ڂ��o���̂ňꌂ�ł��Ȃ��͂��S���Ȃ�ɂȂ�܂���"),
		//HP�A�_���[�W�o��
		MESSAGE_DAMAGE("{0}�̃_���[�W"),
		MESSAGE_MY_HP01("����HP"),
		MESSAGE_MY_HP02("�����cHP"),
		MESSAGE_ENEMY_HP01("����HP"),
		MESSAGE_ENEMY_HP02("����cHP" ),
		//���s�o��
		MESSAGE_JUDGEMENT01("���Ȃ��̏����ł�" ),
		MESSAGE_JUDGEMENT02("�����Ă̏����ł�" ),
		//�G���[���b�Z�[�W
		ERRORMESSAGE01("���̓G���[�ł�"),
		ERRORMESSAGE02("�������R�}���h����͂��Ă�������");

		@Getter
		private String message;

		public void showMessage(Object... argments) {
			System.out.println(MessageFormat.format(this.getMessage(), argments));
		}
	}
	
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	public enum Dice {
		ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6);
		@Getter
		private int num;
		
		
	}
}