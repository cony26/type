package typing_app.com.cony;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
	public static void main(String[] args) {
		(new Game("Typing Game")).addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		System.out.println("main update conflict here");
		System.out.println("conflict here");
	}
}
