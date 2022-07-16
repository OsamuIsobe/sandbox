package daice.dto.character;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import daice.constants.Constants;
import daice.dto.Human;

public class MyCharacter extends Character implements Human {
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	int hp;
	String name;
	public MyCharacter(int hp, String name) {
		super(hp, name);
	}
	public void attack(Character a) {

	}
	//ÉTÉCÉRÉçÇRÇ¬ÇÃçUåÇ
	public void threeAttack(Character enemy) {
		Constants.Message.MESSAGE_DAICE_QUANTITY03.showMessage();
		Constants.Message.MESSAGE_DAICE_DISPLAY01.showMessage();
		int[] daiceQuantity = new int[3];
		for(int i = 0; i < 3 ; i++) {
		Random random = new Random();
		daiceQuantity[i] = random.nextInt(6) + 1;
		}
		System.out.println(daiceQuantity[0] + "," + daiceQuantity[1] + "," + daiceQuantity[2]);
		int totalNum = daiceQuantity[0] + daiceQuantity[1] + daiceQuantity[2];
		System.out.print(totalNum);
		Constants.Message.MESSAGE_DAMAGE.showMessage();
		enemy.setHp(enemy.getHp() - totalNum);
	}
	//ÉTÉCÉRÉçÇQÇ¬ÇÃçUåÇ
	public void twiceAttack(Character enemy) {
		Constants.Message.MESSAGE_DAICE_QUANTITY02.showMessage();
		Constants.Message.MESSAGE_DAICE_DISPLAY01.showMessage();
		int[] daiceQuantity = new int[2];
		for(int i = 0; i < 2 ; i++) {
		Random random = new Random();
		daiceQuantity[i] = random.nextInt(6) + 1;
		}
		if(daiceQuantity[0] == daiceQuantity[1]){
			System.out.println(daiceQuantity[0] + "," + daiceQuantity[1]);
			System.out.println("(" +daiceQuantity[0] + "+" + daiceQuantity[1] + ")" + "Å~3");
			enemy.setHp(enemy.getHp() - ((daiceQuantity[0] + daiceQuantity[1]) *3));
			System.out.print((daiceQuantity[0] + daiceQuantity[1]) *3);
			Constants.Message.MESSAGE_DAMAGE.showMessage();
		}else {
			enemy.setHp(enemy.getHp() - (daiceQuantity[0] + daiceQuantity[1]));
			System.out.println(daiceQuantity[0] + "," + daiceQuantity[1]);
			System.out.print(daiceQuantity[0] + daiceQuantity[1]);
			Constants.Message.MESSAGE_DAMAGE.showMessage();
		}
	}
	//ÉTÉCÉRÉçÇPÇ¬ÇÃçUåÇ
	public void onceAttack(Character enemy) throws IOException{
		Constants.Message.MESSAGE_DAICE_QUANTITY01.showMessage();
		String Number = bufferedReader.readLine();
		int DeclareNum = Integer.parseInt(Number);
		Constants.Message.MESSAGE_DAICE_QUANTITY01_01.showMessage();
		System.out.println(DeclareNum);
		Constants.Message.MESSAGE_DAICE_DISPLAY01.showMessage();
		Random random = new Random();
		int oneDaiceNumber = random.nextInt(6) + 1;
		System.out.println(oneDaiceNumber);
		System.out.print(oneDaiceNumber);
		Constants.Message.MESSAGE_DAMAGE.showMessage();
		if(oneDaiceNumber == DeclareNum) {
			enemy.setHp(enemy.getHp() - 50);
			Constants.Message.MESSAGE_DOUBLET_MYCHARACTER.showMessage();
			enemy.displayHp();
		}else{
			enemy.setHp(enemy.getHp() - oneDaiceNumber);
		}
	}
	
}
