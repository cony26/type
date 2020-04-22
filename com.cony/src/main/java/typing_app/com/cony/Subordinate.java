package typing_app.com.cony;

import java.util.Random;

public class Subordinate extends Enemy{
	Random rand = new Random();
	
	public Subordinate(String name) {
		super(name);
		setParameter(1 + rand.nextInt(Properties.SUBORDINATE_MAX_HP),1 + rand.nextInt(Properties.SUBORDINATE_MAX_AP));
	}
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
