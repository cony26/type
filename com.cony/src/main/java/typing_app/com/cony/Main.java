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
		System.out.println("good morning1");
		System.out.println("good morning2");
		System.out.println("hello");
	}
}
