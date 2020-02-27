package typing_app.com.cony;

//Enemy has boss and subordinates and group. And group has also boss and subordinates and group.
//
public abstract class Enemy {
	private String name;
	private int hp;
	private int attackPoint;
	
	public Enemy() {
	}
	public Enemy(String name) {
		this.name = name;
	}
	
	public int getHP() {
		return hp;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAttackPoint() {
		return attackPoint;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
		
	protected void setParameter(int hp, int attackPoint) {
		this.hp = hp;
		this.attackPoint = attackPoint;
	}
}
