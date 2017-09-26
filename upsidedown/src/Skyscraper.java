import java.awt.Graphics;
import java.awt.Image;

public class Skyscraper {
	private int sizeX,sizeY;
	private int x,y;
	private final Image skyScrapper;
	
	public Skyscraper(int x, int y,int sizeX, int sizeY, Image img) {
		
		skyScrapper = img;
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	public void move() {
		x --;
	}
	
	public void changeSize() {
		
	}
	
	public void paint(Graphics g) {
		
		g.drawImage(skyScrapper, x,y,sizeX,sizeY,null);
	}
	
	public boolean checkCollide(int xRight, int xLeft, int yTop, int yBottom) {
		int left = this.x + 150;
		int right = this.x + sizeX - 150;
		int top = this.y;
		int bottom = this.y + sizeY;			
		
		if(xRight <= left)
			return false;
		if(xLeft >= right)
			return false;
		if(yTop >= bottom)
			return false;
		if(yBottom <= top)
			return false;
		
//		System.out.println("Character" + xRight + " " + xLeft + " " + yTop + " " + yBottom);
//		System.out.println("SkyScrapper" + left + " " + right + " " + bottom + " " + top);
		
		return true;
	}
}
