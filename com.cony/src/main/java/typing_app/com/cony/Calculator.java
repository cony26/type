package typing_app.com.cony;

public class Calculator {
	private Player player;
	private Enemy enemy;
	
	private BattleDisplay bd;
	
	public Calculator(BattleDisplay bd, Player player, Enemy enemy) {
		this.bd = bd;
		this.player = player;
		this.enemy = enemy;
	}
	
	public void yourAttack() {
		enemy.accept(new YourAttackVisitor(player));
		update();
	}
	
	public void enemyAttack() {
		enemy.accept(new EnemyAttackVisitor(player));
		update();
	}
	
	private void update() {
		bd.setYourHPtext(player.getHP());
		bd.setEnemyHPtext(enemy.getHP());
	}
	public int isBattleEnd() {
		if(player.getHP() != 0 && enemy.getHP() != 0) {
			return 0;
		}else if(player.getHP() == 0) {
			return 1;
		}else {
			return -1;
		}
	}
}
