package daice.constants;

import java.text.MessageFormat;
import java.util.Random;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class Constants{

	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	public enum Message {
		//基本出力
		MESSAGE01("\n" +"サイコロの数を入力してください"),
		MESSAGE02("終了しました"),
		//レイアウト
		MESSAGE_LINE01("--------------------------------------------"),
		//ターン出力
		MESSAGE_TURN01("自分のターン"),
		MESSAGE_TURN02("\n" + "相手のターン"),
		//サイコロの数
		MESSAGE_DAICE_DISPLAY01("出た目の数"),
		MESSAGE_DAICE_QUANTITY01("ダイス1つ\n・数を宣言してください"),
		MESSAGE_DAICE_QUANTITY01_01("宣言した数"),
		MESSAGE_DAICE_QUANTITY02("ダイス2つ"),
		MESSAGE_DAICE_QUANTITY03("ダイス３つ"),
		//ゾロ目
		MESSAGE_DOUBLET_MYCHARACTER("ゾロ目が出たので50ダメージ"),
		MESSAGE_DOUBLET_ENEMY("ゾロ目が出たので一撃であなたはお亡くなりになりました"),
		//HP、ダメージ出力
		MESSAGE_DAMAGE("{0}のダメージ"),
		MESSAGE_MY_HP01("自分HP"),
		MESSAGE_MY_HP02("自分残HP"),
		MESSAGE_ENEMY_HP01("相手HP"),
		MESSAGE_ENEMY_HP02("相手残HP" ),
		//勝敗出力
		MESSAGE_JUDGEMENT01("あなたの勝ちです" ),
		MESSAGE_JUDGEMENT02("あいての勝ちです" ),
		//エラーメッセージ
		ERRORMESSAGE01("入力エラーです"),
		ERRORMESSAGE02("正しいコマンドを入力してください");

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