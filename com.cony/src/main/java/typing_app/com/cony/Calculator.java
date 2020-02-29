package typing_app.com.cony;

public class Calculator {
	private Player player;
	private EnemyGroup enemy;
	
	private BattleDisplay bd;
	
	public Calculator(BattleDisplay bd, Player player, EnemyGroup enemy) {
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
}
