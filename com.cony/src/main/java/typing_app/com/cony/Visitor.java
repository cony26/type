package typing_app.com.cony;

public abstract class Visitor {
	
	public abstract void visit(Boss boss);
	public abstract void visit(Subordinate subordinate);
	public abstract void visit(EnemyGroup enemyGroup);
}
