import java.awt.Color;

public interface Colleague {
	void setMediator(Mediator mediator);
	abstract void controlColleague(boolean enabled, Color color);
}
