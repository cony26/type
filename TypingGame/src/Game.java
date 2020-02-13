import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Game extends JFrame implements ActionListener,KeyListener{
	private final static String[] KEYBOARD= {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"," "};
	private Map<String,JButton> map = new HashMap<String,JButton>();
	private JButton startButton = new JButton("start");
	private JButton stopButton = new JButton("stop");
	private JTextField examText = new JTextField();
	private JTextField enterText = new JTextField();
	private boolean isStart = false;
	private boolean isClear = false;
	private int index = 0;
	private Random rand = new Random();
	private JButton before;
	
	public Game(String title) {
		super(title);
		
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		enterText.addKeyListener(this);
		
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		Box menuBox = new Box(BoxLayout.X_AXIS);
		menuBox.add(startButton);
		menuBox.add(stopButton);
		mainBox.add(menuBox);
		
		Box[] keyBox = {new Box(BoxLayout.X_AXIS),new Box(BoxLayout.X_AXIS),new Box(BoxLayout.X_AXIS),new Box(BoxLayout.X_AXIS)};
		for(int i = 0; i < KEYBOARD.length;i++) {
			for(int j = 0; j < KEYBOARD[i].length(); j++) {
				JButton tmp = new JButton(""+KEYBOARD[i].charAt(j));
				keyBox[i].add(tmp);
				map.put(""+KEYBOARD[i].charAt(j),tmp);
				tmp.setBackground(Color.WHITE);
			}
			mainBox.add(keyBox[i]);
		}
		
		examText.setEnabled(false);
		enterText.setEnabled(false);
		examText.setBackground(Color.LIGHT_GRAY);
		enterText.setBackground(Color.LIGHT_GRAY);
		mainBox.add(examText);
		mainBox.add(enterText);
		
		getContentPane().add(mainBox);
		pack();
		show();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton) {
			isStart=true;
			isClear=true;
			update();
		}else if(e.getSource() == stopButton) {
			isStart=false;
			isClear=false;
			update();
		}
	}
	
	public void keyTyped(KeyEvent e) {
	}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() != e.VK_SHIFT) {
			String str = enterText.getText();
			String str2 = examText.getText();
			if(before != null) 
				before.setBackground(Color.white);
			before = map.get(""+str.toUpperCase().charAt(index));
			before.setBackground(Color.CYAN);
			if(str.charAt(index) == str2.charAt(index)) {
				if(index < str2.length() - 1) {
					index++;
					isClear = false;
				}else {
					isClear = true;
				}
			}else {
				if(index != 0)
					enterText.setText(str.substring(0,index));
				if(index == 0)
					enterText.setText("");
			}
			update();
		}
	}
	
	private void update() {
		if(isClear) {
			examText.setText(SENTENCES.values()[rand.nextInt(SENTENCES.values().length-1)].getValue());
			enterText.setText("");
			isClear=false;
			index=0;
		}
		if(!isStart) {
			enterText.setEnabled(false);
			enterText.setBackground(Color.LIGHT_GRAY);
		}else {
			enterText.setEnabled(true);
			enterText.setBackground(Color.WHITE);
		}
	}

}
