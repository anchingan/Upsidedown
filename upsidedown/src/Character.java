import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Character{

	private enum state{
		ALIVE,
		DEAD
	}
	Image character;
	Image characterExplode;
	private state state;
	private final int width, height;
	private final int x;
	private final int yDwnVelocityInitial;
	private int yDwnVelocity;
	private int yDwnIncrement;
	private int y;
	private int yAccel;
	
	public Character() {
		character = new ImageIcon(getClass().getResource("burger.png")).getImage();
		characterExplode = new ImageIcon(getClass().getResource("explode.png")).getImage();
		state = state.ALIVE;
		width = 70;
		height = 85;
		x = 160;
		y = 320;
		yDwnVelocityInitial = 2;
		yDwnVelocity = yDwnVelocityInitial;
		yDwnIncrement = 2;
		yAccel = -90;
	}
	
	public void explode() {
		state = state.DEAD;
	}
	
//	public void move() {
//		this.vy += this.ay;
//		this.y += this.vy;
//		if (this.ay < 0) {
//			this.ay = this.ayInt;
//			this.vy = 0;
//		}
//	}
	
	public void move() {
		y += yDwnVelocity;
		yDwnVelocity += yDwnIncrement;
		if(yDwnVelocity < 0) {
			yDwnVelocity = yDwnVelocityInitial;
		}
	}
	
	public void accel() {
		yDwnVelocity += yAccel;
	}
	
	public void paint (Graphics g) {
		if(state == state.ALIVE)
			g.drawImage(character, x, y, width, height, null);
		else if(state == state.DEAD)
			g.drawImage(characterExplode, x, y, width, height, null);
	}
	
	public int getTopY() {
		return y;
	}
	
	public int getBottomY() {
		return y + height;
	}
	
	public int getLeftX() {
		return x;
	}
	
	public int getRightX() {
		return x + width;
	}
	
}
