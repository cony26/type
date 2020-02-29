package typing_app.com.cony;

public class BattleLauncher implements Launcher{
	private Enemy enemy;
	private Player player;
	public BattleLauncher() {
	}
	
	public void createPlayers() {
		player = new Player();
		player.setHP(Properties.PLAYER_DEFAULT_HP);
		player.setAttackPoint(Properties.PLAYER_DEFAULT_AP);
		
		enemy = new EnemyGroup("dark group");
		try {
			enemy.add(new Boss("boss1"));
			enemy.add(new Subordinate("sub1-1"));
			enemy.add(new Subordinate("sub1-2"));
			Enemy group2 = new EnemyGroup("group2");
			group2.add(new Boss("boss2"));
			group2.add(new Subordinate("sub2-1"));
			group2.add(new Subordinate("sub2-2"));
			group2.add(new Subordinate("sub2-3"));
			Enemy group3 = new EnemyGroup("group3");
			group3.add(new Boss("boss3"));
			group3.add(new Subordinate("sub3-1"));
			Enemy group4 = new EnemyGroup("group4");
			group4.add(new Boss("boss4"));
			group4.add(new Subordinate("sub4-1"));
			enemy.add(group2);
			group2.add(group3);
			group2.add(group4);
			
		}catch(Exception e) {
			System.out.println("wrong enemy created");
			System.exit(0);
		}
	}
	
	public Player getPlayer() {
		return player;
	}
	public Enemy getEnemy() {
		return enemy;
	}
}
