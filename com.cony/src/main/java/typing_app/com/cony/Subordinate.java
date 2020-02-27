package typing_app.com.cony;

import java.util.Random;

public class Subordinate extends Enemy{
	Random rand = new Random();
	public static final int SUBORDINATE_MAX_HP=5;
	public static final int SUBORDINATE_MAX_AP=5;
	
	public Subordinate(String name) {
		super(name);
		setParameter(rand.nextInt(SUBORDINATE_MAX_HP),rand.nextInt(SUBORDINATE_MAX_AP));
	}
}
