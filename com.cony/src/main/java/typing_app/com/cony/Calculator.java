package typing_app.com.cony;

public class Calculator {
	private int yourHP;
	private int enemyHP;
	
	private BattleDisplay bd;
	
	public Calculator(BattleDisplay bd) {
		this.bd = bd;
	}
	
	public void yourAttack() {
		(new AttackVisitor(this)).visit((EnemyGroup)bd.getEnemy());
	}
	
	public void enemyAttack() {
		
	}
}
