package typing_app.com.cony;

import java.util.Random;

public class Boss extends Enemy{
	Random rand = new Random();
	public static final int BOSS_HP_MAX = 10;
	public static final int BOSS_AP_MAX = 10;
	
	public Boss() {
		super();
	}
	public Boss(String name) {
		super(name);
		setParameter(rand.nextInt(BOSS_HP_MAX),rand.nextInt(BOSS_AP_MAX));
	}

}
