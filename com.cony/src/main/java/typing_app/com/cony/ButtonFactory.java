package typing_app.com.cony;
import javax.swing.JButton;

public class ButtonFactory extends Factory{
	public Product create(String ch) {
		return (Product)new ColleagueButton(ch);
	}
}