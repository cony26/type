package typing_app.com.cony;

import java.util.ArrayList;

//Enemy has boss and subordinates and group. And group has also boss and subordinates and group.
//
public abstract class Enemy {
	private String name;
	private Player enemy;
	private Enemy parent;
	
	public Enemy() {
	}
	public Enemy(String name) {
		this.name = name;
		this.enemy = new Player();
	}
	
	public void registerParent(Enemy parent) {
		this.parent = parent;
	}
	
	public Enemy getParent() {
		return parent;
	}
	
	public int getHP() {
		return enemy.getHP();
	}
	
	public String getName() {
		return name;
	}
	
	public int getAttackPoint() {
		return enemy.getAttackPoint();
	}
		
	protected void setParameter(int hp, int attackPoint) {
		enemy.setHP(hp);
		enemy.setAttackPoint(attackPoint);
	}
	public void setHP(int hp) {
		enemy.setHP(hp);
	}
	public void add(Enemy enemy) throws Exception{
		throw new Exception();
	}
	public boolean isBossOnly(Boss boss){
		return false;
	}
	
	public abstract void accept(Visitor visitor);
	
	public String toString() {
		return name;
	}
}
