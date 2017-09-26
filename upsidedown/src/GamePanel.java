import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JPanel;
//import javax.swing.Timer;



public class GamePanel extends JPanel{	
	
	private  final GameScene gameScene;
	private  final Timer objectMoveTimer;
	private  final Timer characterMoveTimer;
	private  final AudioClip jump;
	private  final AudioClip backGround;
	private  final AudioClip fail;
	private  final int objectMoveSec;
	private  final int characterMoveSec;
	private  Character character;
	private  SkyscraperList skyscraperList;
	private int gameSceneX;	
	private JPanel jp;

	
	public GamePanel() {	

		gameScene = new GameScene(1200,720);
		gameSceneX = 0;		
		character = new Character();
		skyscraperList = new SkyscraperList();
		objectMoveSec = 10;
		characterMoveSec = 50;		
		jump = Applet.newAudioClip(getClass().getResource("jump.wav"));
		backGround = Applet.newAudioClip(getClass().getResource("background.wav"));
		fail = Applet.newAudioClip(getClass().getResource("fail.wav"));
		this.addMouseListener(new CMouseListener1());
		this.addMouseMotionListener(new CMouseListener1());
		this.addKeyListener(new CKey()); //new
		this.setFocusable(true); //new
		this.setLayout(null);

		this.add(gameScene);
		backGround.loop();
		
		objectMoveTimer = new Timer(objectMoveSec, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {				
				gameScene.setLocation(gameSceneX--, 0);				
			    skyscraperList.moveAll();				
			    if(skyscraperList.checkCollideAll(character)) {
				    	character.explode();
				    	backGround.stop();
				    	fail.play();
				    	objectMoveTimer.stop();
				    	characterMoveTimer.stop();
				    	GameStart.state = GameStart.STATE.FAIL;	
			    }
			}	
		});

		characterMoveTimer = new Timer(characterMoveSec, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				character.move();				
			}
		});
		
		
		characterMoveTimer.start();
		objectMoveTimer.start();
	}
	
	@Override public void paint(Graphics g) {		
		super.paint(g);		
		skyscraperList.paintAll(g);
		character.paint(g);		
	}
	
	class CMouseListener1 extends MouseAdapter{
		@Override public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1)
				character.accel();
				jump.play();
		}
	}
	
	class CKey extends KeyAdapter{
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				character.accel();
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				character.forward();
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				character.back();
		}
	}
	
	public void restart() {
		gameSceneX = 0;		
		character = new Character();
		skyscraperList = new SkyscraperList();
		backGround.loop();
		characterMoveTimer.start();
		objectMoveTimer.start();
	}
}
