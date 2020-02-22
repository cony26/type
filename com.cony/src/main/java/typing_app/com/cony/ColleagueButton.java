package typing_app.com.cony;
import java.awt.Color;

import javax.swing.JButton;

public class ColleagueButton extends JButton implements Colleague{
	Mediator mediator;
	
	public ColleagueButton(String title) {
		super(title);
	}
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	public void controlColleague(boolean enabled,Color color) {
		setEnabled(enabled);
		setBackground(color);
	}
}
