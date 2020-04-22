package typing_app.com.cony;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
	private Calculator calculator;
	
	public BattleDisplay(Launcher launcher) {
		//display canvas and HP
		launcher.createPlayers();
		player = launcher.getPlayer();
		enemy = launcher.getEnemy();
		calculator = new Calculator(this,player,enemy);
		yourHPtext = new JTextField();
		yourHPtext.setEditable(false);
		yourHPtext.setFont(new Font(Font.DIALOG,Font.BOLD,16));
		yourHPtext.setForeground(Color.blue);
		yourHPtext.setText("" + player.getHP());
		enemyHPtext = new JTextField();
		enemyHPtext.setEditable(false);
		enemyHPtext.setFont(new Font(Font.DIALOG,Font.BOLD,16));
		enemyHPtext.setForeground(Color.RED);
		enemyHPtext.setText("" + enemy.getHP());
		
		canvas = new DrawCanvas(300,500, enemy);
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
	public void yourAttack() {
		calculator.yourAttack();
		canvasUpdate();
	}
	public void enemyAttack() {
		calculator.enemyAttack();
		canvasUpdate();
	}
	public boolean isBattleEnd() {
		if(calculator.isBattleEnd() == 0) {
			return false;
		}else{
			return true;
		}
	}
	public void canvasUpdate() {
		canvas.repaint();

	}
}
