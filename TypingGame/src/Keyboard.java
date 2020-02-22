import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class Keyboard extends Box implements Colleague{
	private Mediator mediator;
	private final static String[] KEYBOARD= {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"," "};
	private Map<String,JButton> map = new HashMap<String,JButton>();
	
	public Keyboard() {
		super(BoxLayout.Y_AXIS);
		for(int i = 0; i < KEYBOARD.length;i++) {
			Box rowBox = new Box(BoxLayout.X_AXIS);
			for(int j = 0; j < KEYBOARD[i].length(); j++) {
				JButton tmp = new JButton(""+KEYBOARD[i].charAt(j));
				tmp.setBackground(Color.white);
				rowBox.add(tmp);
				map.put(""+KEYBOARD[i].charAt(j),tmp);
				rowBox.setBackground(Color.WHITE);
			}
			this.add(rowBox);
		}
	}
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	public void controlColleague(boolean enabled,Color color) {
		setEnabled(enabled);
		setBackground(color);
	}
	public Map<String,JButton> getMap(){
		return map;
	}
}
