import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameStart {
	public static enum STATE{
		FAIL,
		ALIVE
	}	
	public static STATE state;
	private static  Timer checkGameStateTimer = null;
	private static GamePanel gp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		gp = new GamePanel();
		gp.setSize(1200, 720);
		
		
		
		
		checkGameStateTimer = new Timer(10, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(state == STATE.FAIL) {
					gp.restart();					
					//checkGameStateTimer.stop();
					
					state = STATE.ALIVE;
				}
			}
		});
		
		frame.setLayout(null);				
		frame.setSize(1200, 720);
		frame.add(gp);		
		frame.setVisible(true);
		
		
		
		
		
		checkGameStateTimer.start();
		
	}

}
