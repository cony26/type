package typing_app.com.cony;

import java.util.ArrayList;
import java.util.Iterator;

public class EnemyGroup extends Enemy{
	private ArrayList<Enemy> member = new ArrayList<Enemy>();
	public EnemyGroup(String name) {
		super(name);
	}
	
	public void add(Enemy enemy) {
		member.add(enemy);
		enemy.registerParent(this);
	}
	
	@Override
	public int getHP() {
		Iterator<Enemy> ite = member.iterator();
		int tmp_hp = 0;
		while(ite.hasNext()) {
			tmp_hp += ite.next().getHP();
		}
		return tmp_hp;
	}
	
	@Override
	public int getAttackPoint() {
		Iterator<Enemy> ite = member.iterator();
		int tmp_attackPoint=0;
		while(ite.hasNext()) {
			tmp_attackPoint += ite.next().getAttackPoint();
		}
		return tmp_attackPoint;
	}
	
	@Override
	public boolean isBossOnly(Boss boss) {
		if(boss.getHP() == getHP())
			return true;
		else
			return false;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	public Iterator<Enemy> getIterator(){
		return member.iterator();
	}
}
