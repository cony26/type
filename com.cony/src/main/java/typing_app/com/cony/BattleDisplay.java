package typing_app.com.cony;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class BattleDisplay extends JFrame{
	private JTextField yourHPtext;
	private JTextField enemyHPtext;
	private Canvas canvas;
	private Enemy enemy;
	private Player player;
	
	public BattleDisplay(Launcher launcher) {
		//display canvas and HP
		launcher.createPlayers();
		yourHPtext = new JTextField();
		yourHPtext.setEnabled(false);
		enemyHPtext = new JTextField();
		enemyHPtext.setEnabled(false);
		canvas = new Canvas();
		canvas.setSize(300, 300);
		canvas.setBackground(Color.BLACK);
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		Box HPBox = new Box(BoxLayout.X_AXIS);
		HPBox.add(yourHPtext);
		HPBox.add(enemyHPtext);
		mainBox.add(HPBox);
		mainBox.add(canvas);
		
		getContentPane().add(mainBox);
		setLocation(200,200);
		pack();
		show();
		
	}
	
	public void setYourHPtext(int yourHP) {
		yourHPtext.setText(""+yourHP);
	}
	public void setEnemyHPtext(int enemyHP) {
		enemyHPtext.setText(""+enemyHP);
	}
	public Enemy getEnemy() {
		return enemy;
	}
	
}
