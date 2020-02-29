package typing_app.com.cony;

public class AttackVisitor extends Visitor{
	private Calculator calculator;
	
	public AttackVisitor(Calculator calcurator) {
		this.calculator = calcurator;
	}

	@Override
	public void visit(Boss boss) {
		boss.getAttackPoint();
	}

	@Override
	public void visit(Subordinate subordinate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(EnemyGroup enemyGroup) {
		// TODO Auto-generated method stub
		
	}

}
