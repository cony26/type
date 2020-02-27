package typing_app.com.cony;

public class attackVisitor extends Visitor{
	private Calcurator calculator;
	
	public attackVisitor(Calculator calcurator) {
		this.calculator = calcurator;
	}

	@Override
	public void visit(Boss boss) {
		boss.getAttackPoint();
		calcurator
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
