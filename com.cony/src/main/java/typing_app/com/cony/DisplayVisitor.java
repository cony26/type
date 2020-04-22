package typing_app.com.cony;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

public class DisplayVisitor extends Visitor{

	private Graphics g;
	private int x = 0;
	private int y = 20;
	private int groupNumber = -1;
	
	
	public DisplayVisitor(Graphics g) {
		this.g = g;
	}
	
	@Override
	public void visit(Boss boss) {
		// TODO Auto-generated method stub
		x = groupNumber * 40;
		g.setColor(Color.BLACK);
		g.drawString(""+boss, x, y);
		g.setColor(Color.RED);
		g.fillRect(x + 10, y + 10, 10, 10);
		y += 40;
	}

	@Override
	public void visit(Subordinate subordinate) {
		// TODO Auto-generated method stub
		x = groupNumber * 40;
		g.setColor(Color.BLACK);
		g.drawString(""+subordinate, x, y);
		g.setColor(Color.GREEN);
		g.fillRect(x + 10, y + 10, 10, 10);
		y += 40;
	}

	@Override
	public void visit(EnemyGroup enemyGroup) {
		// TODO Auto-generated method stub
		Iterator<Enemy> ite = enemyGroup.getIterator();
		groupNumber++;
		while(ite.hasNext()) {
			ite.next().accept(this);
		}
		groupNumber--;
	}
	
}
