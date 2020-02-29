package typing_app.com.cony;

import java.util.Iterator;

//attack target is only suborinate and group
//boss is the last one that is attacked.
public class YourAttackVisitor extends Visitor{
	private Player player;
	
	public YourAttackVisitor(Player player) {
		this.player = player;
	}

	@Override
	public void visit(Boss boss) {
		if(boss.getParent().isBossOnly(boss)) {
			int tmp = boss.getHP() - player.getAttackPoint() / 2;
			if(tmp > 0) {
				boss.setHP(tmp);
			}else {
				boss.setParameter(0, 0);
			}
		}
	}

	@Override
	public void visit(Subordinate subordinate) {
		// TODO Auto-generated method stub
		int tmp = subordinate.getHP() - player.getAttackPoint();
		if(tmp > 0) {
			subordinate.setHP(tmp);
		}else {
			subordinate.setParameter(0, 0);
		}
	}

	@Override
	public void visit(EnemyGroup enemyGroup) {
		// TODO Auto-generated method stub
		Iterator<Enemy> ite = enemyGroup.getIterator();
		while(ite.hasNext()) {
			ite.next().accept(this);
		}
	}

}
