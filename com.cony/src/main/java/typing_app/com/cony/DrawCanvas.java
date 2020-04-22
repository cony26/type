package typing_app.com.cony;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class DrawCanvas extends Canvas{
	private Color color = Color.BLACK;
	private Enemy enemy;
	
	public DrawCanvas(int width, int height, Enemy enemy) {
		this.enemy = enemy;
		setSize(width,height);
		setBackground(Color.WHITE);
		setFont(new Font(Font.DIALOG,Font.BOLD,16));
		setForeground(Color.black);
	}
	
	public void paint(Graphics g) {
		g.setColor(color);
//		g.drawString("test", 10, 20);
		enemy.accept(new DisplayVisitor(g));
	}
}
