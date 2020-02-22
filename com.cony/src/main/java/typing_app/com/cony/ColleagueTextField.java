package typing_app.com.cony;
import java.awt.Color;

import javax.swing.JTextField;

public class ColleagueTextField extends JTextField implements Colleague{
	Mediator mediator;
	public ColleagueTextField() {
		super();
	}
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	public void controlColleague(boolean enabled,Color color) {
		setEnabled(enabled);
		setBackground(color);
	}
}
