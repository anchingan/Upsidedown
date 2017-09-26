import java.awt.Graphics;
import java.awt.Image;

public class Skyscraper {
	private final int sizeYInitial;
	private final Image skyScrapper;
	private int x,y;
	private int sizeX,sizeY;
	private Boolean enlargeable;
	private Boolean baseMove;
	private int enlargeMax;
	private int enlargeDir;
	
	public Skyscraper(int x, int y,int sizeX, int sizeY, Image img) {
		
		baseMove = false;
		skyScrapper = img;
		this.enlargeMax = 0;
		this.enlargeable = false;
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.sizeYInitial = sizeY;
		enlargeDir = 0;

	}
	
	public void setBaseMove(Boolean b) {
		baseMove= b;
	}
	
	public void setEnlargeable(Boolean b) {
		enlargeable = b;
	}
	
	
	
	public Boolean getEnlargeable() {
		return enlargeable;
	}
	
		
 	public void setEnlargeMax(int max) {
		enlargeMax = max;
	}

	

 	public void enlarge() {
		
		if(enlargeDir == 0) {
			 if(sizeY < enlargeMax) {
				 sizeY ++;
				 if(baseMove)
					 y --;
			 }
			 else {
				 enlargeDir = 1;
			 }
		}
		
		if(enlargeDir == 1) {
			if(sizeY > sizeYInitial) {
				sizeY --;
				if(baseMove)
					y ++;
			}				
			else {
				enlargeDir = 0;
			}
		}
		
		
	}
	
 	
 	
	public void move() {
		x --;
	}
	
	public Boolean outOfScene() {
		if(x + sizeX < 0)
			return true;
		return false;
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
