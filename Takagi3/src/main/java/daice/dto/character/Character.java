package daice.dto.character;

import java.io.IOException;

public class Character{
	private int hp;
	String name;

	public Character(int hp, String name) {
		super();
		this.setHp(hp);
		this.name = name;
	}
	public void onceAttack(Character character) throws IOException{

	}
	public void twiceAttack(Character character) {

	}
	public void threeAttack(Character character) {

	}
	public void attack(Character character) {

	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getHp() {
		return hp;
	}
	public void displayHp() {
		System.out.println(getHp());
	}
	public boolean judgementBattle(){
		if(hp < 0 ) {
		return false;
		}else{
		return true;
		}
	}
}