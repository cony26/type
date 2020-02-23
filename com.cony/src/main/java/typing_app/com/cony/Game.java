package typing_app.com.cony;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComponent;

public class Game extends JFrame implements Mediator,ActionListener,KeyListener{
	private Map<String,JButton> map;
	private JButton beforePressed=null;
	private ColleagueButton startButton;
	private ColleagueButton stopButton;
	private Keyboard keyboard;
	private ColleagueTextField examText;
	private ColleagueTextField enterText;
	private boolean isStart = false;
	private boolean isClear = false;
	private int index = 0;
	private boolean isPress=false;
	private boolean isOverlapped = false;
	private Random rand = new Random();
	private int typeTotal=0;
	private int typeCorrect=0;

	public void createColleagues() {
		startButton = new ColleagueButton("start typing game");
		stopButton = new ColleagueButton("stop typing game");
		keyboard = new Keyboard();
		map = keyboard.getMap();
		examText = new ColleagueTextField();
		examText.setEditable(false);
		enterText = new ColleagueTextField();

		startButton.setMediator(this);
		stopButton.setMediator(this);
		keyboard.setMediator(this);
		examText.setMediator(this);
		enterText.setMediator(this);
		
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		enterText.addKeyListener(this);
		
	}
	
	public Game(String title) {
		super(title);	
		createColleagues();
		
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		Box menuBox = new Box(BoxLayout.X_AXIS);
		menuBox.add(startButton);
		menuBox.add(stopButton);
		mainBox.add(menuBox);
		mainBox.add(keyboard);
		mainBox.add(examText);
		mainBox.add(enterText);
		
		getContentPane().add(mainBox);
		colleagueChanged();
		
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
		}
		colleagueChanged();
	}
	
	public void colleagueChanged() {
		if(isStart) {
			startButton.controlColleague(!isStart, Color.LIGHT_GRAY);
			stopButton.controlColleague(isStart, Color.WHITE);
			keyboard.controlColleague(isStart, Color.WHITE);
			examText.controlColleague(isStart, Color.WHITE);
			enterText.controlColleague(isStart,Color.WHITE);
			enterText.requestFocusInWindow();
		}else {
			startButton.controlColleague(!isStart, Color.WHITE);
			stopButton.controlColleague(isStart, Color.LIGHT_GRAY);
			keyboard.controlColleague(isStart, Color.LIGHT_GRAY);
			examText.controlColleague(isStart, Color.LIGHT_GRAY);
			enterText.controlColleague(isStart,Color.LIGHT_GRAY);
		}
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {

		String enter = enterText.getText();
		String exam = examText.getText();
		if(e.getKeyCode() != e.VK_SHIFT) {
			typeTotal++;
			if(beforePressed != null) 
				beforePressed.setBackground(Color.white);
			JButton tmp;
			try {
				tmp = map.get(""+enter.toUpperCase().charAt(index));
			}catch(Exception ee) {
				return;
			}
			if(tmp != null) {
				beforePressed = tmp;
				beforePressed.setBackground(Color.CYAN);
			}
			if(enter.charAt(index) == exam.charAt(index)) {
				typeCorrect++;
				if(index < exam.length() - 1) {
					index++;
				}else {
					isClear = true;
				}
			}else {			
				if(index != 0)
					enterText.setText(enter.substring(0,index));
				if(index == 0)
					enterText.setText("");
			}
			update();
		}
	}
	
	private void update() {
		if(isClear) {
			examText.setText(SENTENCES.values()[rand.nextInt(SENTENCES.values().length)].getValue());
			enterText.setText("");
			isClear=false;
			index=0;
		}
		if(typeTotal!=0)
			System.out.println(typeCorrect + " / " + typeTotal + "(" + (typeCorrect * 100 / typeTotal ) + ") : correct / type (%)");
	}

}
