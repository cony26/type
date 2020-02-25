package typing_app.com.cony;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
	public static void main(String[] args) {
		(new Game("Typing Game")).addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
<<<<<<< master
				System.out.println("branch2 - 1");
				System.out.println("branch2 - 2");
=======
>>>>>>> 371fd08 1
				System.exit(0);
			}
		});
		System.out.println("yeah1");
		System.out.println("yeah2");
		System.out.println("after merge");
	}
}
