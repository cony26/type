package typing_app.com.cony;

import java.util.Random;

public class Boss extends Enemy{
	Random rand = new Random();
	
	public Boss() {
		super();
	}
	public Boss(String name) {
		super(name);
		setParameter(1 + rand.nextInt(Properties.BOSS_HP_MAX),1 + rand.nextInt(Properties.BOSS_AP_MAX));
	}
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
