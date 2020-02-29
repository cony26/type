package typing_app.com.cony;

import java.util.Iterator;
import java.util.Random;

public class EnemyAttackVisitor extends Visitor{
	private Player player;
	Random rand = new Random();
	
	public EnemyAttackVisitor(Player player) {
		this.player = player;
	}
	
	@Override
	public void visit(Boss boss) {
		// TODO Auto-generated method stub
		if(rand.nextInt(100) < Properties.BOSS_ATTACK_PROB) {
			player.setHP(player.getHP() - boss.getAttackPoint());
		}
	}

	@Override
	public void visit(Subordinate subordinate) {
		// TODO Auto-generated method stub
		if(rand.nextInt(100) < Properties.SUBORDINATE_ATTACK_PROB) {
			player.setHP(player.getHP() - subordinate.getAttackPoint());
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
