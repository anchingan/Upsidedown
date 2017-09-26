import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.SwingConstants;

public class GameStart {
	public static enum STATE{
		FAIL,
		ALIVE,
		PAUSE
	}	
	public static STATE state;
	private static  Timer checkGameStateTimer;
	private static GamePanel gp;
	private static Timer countdownTimer;
	private static Dialog dialog;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		dialog = new Dialog(frame);
		gp = new GamePanel();
		gp.setSize(1200, 720);
		Countdown cd = new Countdown(); //new
		cd.setBounds(0, 0, 5000, 720);  //new
		frame.add(cd);  //new
		GameScene gc = new GameScene(5000, 720);  //new
		frame.add(gc);  //new
		frame.setLayout(null);				
		frame.setSize(1200, 720);
		frame.setVisible(true);
		//new
		
		countdownTimer = new Timer(800, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.next();
				frame.repaint();
				if (cd.index > 3) {
					cd.next();
					frame.repaint();
					frame.remove(gc);
					frame.remove(cd);
					frame.add(gp);	
					checkGameStateTimer.start();
					gp.restart();
					countdownTimer.stop();
				}
			}
		});
		countdownTimer.start(); //new
		checkGameStateTimer = new Timer(10, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(state == STATE.FAIL) {
					dialog.show(); //new
					gp.restart();
				}
			}
		});
	}

}

