package typing_app.com.cony;

//Enemy has boss and subordinates and group. And group has also boss and subordinates and group.
//
public abstract class Enemy {
	private String name;
	private Player enemy;
	
	public Enemy() {
	}
	public Enemy(String name) {
		this.name = name;
		this.enemy = new Player();
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
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
		
	protected void setParameter(int hp, int attackPoint) {
		enemy.setHP(hp);
		enemy.setAttackPoint(attackPoint);
	}
}
