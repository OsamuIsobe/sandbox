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
	//サイコロ攻撃
	public void attack(Character myCharacter) {
		Constants.Message.MESSAGE_DAICE_DISPLAY01.showMessage();
		// サイコロの個数をゲームの設定クラスで保持する
		// サイコロの値はfor文の外にListを作り、そこに代入していく。
		List<Integer> diceResultList = new ArrayList<Integer>();
		for(int i = 0; i < GameConfig.usingDiceNum; i++) {
			// gameUtilsクラスに出目を取得するメソッドを作ることで、ramdomメソッドの呼び出し回数を減らす。
			diceResultList.add(gameUtils.throwDice());
		}
		// StreamAPIを使うことでダイスの目の出力が1行で書ける
		diceResultList.stream().forEach(e -> System.out.print(e + " "));
		// 出た目に応じてダメージを与える
		attackCharacter(diceResultList, myCharacter);
//		Random random = new Random();
//		int firstDaice = random.nextInt(6) + 1;
//		int secondDaice = random.nextInt(6) + 1;
//		int thirdDaice = random.nextInt(6) + 1;
//		System.out.print(firstDaice + ",");
//		System.out.print(secondDaice + ",");
//		System.out.print(thirdDaice + "\n");
//		//ゾロ目だった場合
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
	// そのクラスでしか使わないようなメソッドはprivateにして他のクラスで使われない
	// ようにし、同クラス内で定義する。メソッドにして呼び出すことで、ソースの流れを
	// 読みやすくする
	/**
	 * サイコロの出た目の合計値分、相手にダメージを与える。
	 * ゾロ目の場合は、相手のライフを0にする。
	 * @param diceList サイコロの出目のリスト
	 * @param myCharacter 相手キャラクター
	 */
	public void attackCharacter(List<Integer> diceList, Character myCharacter) {
		// ダイスの一投目とすべての要素が同じ数字だった場合にtrueを返す。
		boolean flg = diceList.stream().allMatch(e -> e.equals(diceList.get(0)));
		if(flg) {
			myCharacter.setHp(0);
			// showMessageの引数を可変長にしているので、引数の個数が違っても、
			//　同じメソッドでメッセージを呼び出せる。
			Message.MESSAGE_DOUBLET_ENEMY.showMessage();
		} else {
			int totalNum = diceList.stream().mapToInt(e -> e).sum();
			myCharacter.setHp(myCharacter.getHp() - totalNum);
			// showMessageの引数を可変長にしているので、引数の個数が違っても、
			//　同じメソッドでメッセージを呼び出せる。
			Message.MESSAGE_DAMAGE.showMessage(totalNum);
		}
	}

}