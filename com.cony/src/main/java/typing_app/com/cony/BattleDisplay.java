package typing_app.com.cony;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class BattleDisplay extends JFrame{
	private JTextField yourHP;
	private JTextField enemyHP;
	private Canvas canvas;
	
	public BattleDisplay() {
		//display canvas and HP
		yourHP = new JTextField();
		enemyHP = new JTextField();
		canvas = new Canvas();
		canvas.setSize(300, 300);
		canvas.setBackground(Color.BLACK);
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		Box HPBox = new Box(BoxLayout.X_AXIS);
		HPBox.add(yourHP);
		HPBox.add(enemyHP);
		mainBox.add(HPBox);
		mainBox.add(canvas);
		
		getContentPane().add(mainBox);
		setLocation(200,200);
		pack();
		show();
		
	}
	
}
