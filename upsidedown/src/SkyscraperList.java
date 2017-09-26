import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class SkyscraperList {
	
	private enum size{
		LARGEUP,
		LARGEDOWN,
		MEDIUMUP,
		MEDIUMDOWN,
		SMALLUP,
		SMALLDOWN,
		MINIUP,
		MINIDOWN
	}
	private final ArrayList<Skyscraper> skyscraperList;
	private final int largeSspY,largeSspDwnY;
	private final int medSspY,medSspDwnY;
	private final int smlSspY,smlSspDwnY;
	private final int width;
	private final int lHeight,mHeight,sHeight;
	private int skyscraperX;
	Image skyscraper;
	Image skyscraperd;
	
	
	public SkyscraperList() {
		skyscraper = new ImageIcon(getClass().getResource("skyscraper.png")).getImage();
		skyscraperd = new ImageIcon(getClass().getResource("skyscraperd.png")).getImage();
		skyscraperList = new ArrayList<Skyscraper>();
		lHeight = 300;
		mHeight = 180;
		sHeight = 120;
		largeSspY = 330;
		largeSspDwnY = 0;
		medSspY = largeSspY + (lHeight - mHeight);
		medSspDwnY = 0;
		smlSspY = largeSspY + (lHeight - sHeight);
		smlSspDwnY = 0;
		skyscraperX = 400;
		width = 400;
		
		setStage1();
		setStage2();
		setStage3();
	}
	
	private void setStage1() {
				
		for(int i = 0; i < 4; i ++) {
			Skyscraper sky;
			
			if(i % 2 == 0) 
				this.addSsp(size.LARGEUP);
			else 
				this.addSsp(size.LARGEDOWN);;			
						
			skyscraperX += 250;
		}
	}

	private void setStage2() {
		for(int i = 0; i < 4; i ++) {
			
			if(i % 2 == 0) 
				this.addSsp(size.LARGEUP);			
			else 
				this.addSsp(size.LARGEDOWN);
			
			skyscraperX += 220;
		}
	}
	
	private void setStage3() {
		Skyscraper sky;
		
		this.addSsp(size.LARGEUP);
		this.addSsp(size.MEDIUMDOWN);
			
		skyscraperX += 220;
		
		this.addSsp(size.MEDIUMUP);
		this.addSsp(size.LARGEDOWN);
						
		skyscraperX += 220;
		
		for(int i = 0 ; i < 3; i++) {
			this.addSsp(size.MEDIUMDOWN);
			this.addSsp(size.LARGEUP);			
			skyscraperX += width;
		}
		
		this.addSsp(size.SMALLUP);
		this.addSsp(size.LARGEDOWN);
		
	}

	private void addSsp(size s) {		
		
		if(s == s.LARGEUP)
			this.skyscraperList.add(new Skyscraper(skyscraperX, largeSspY,width,lHeight,skyscraper));
		else if(s == s.LARGEDOWN)
			this.skyscraperList.add(new Skyscraper(skyscraperX, largeSspDwnY,width,lHeight,skyscraperd));
		else if(s == s.MEDIUMDOWN)
			this.skyscraperList.add(new Skyscraper(skyscraperX, medSspDwnY,width,mHeight,skyscraper));
		else if(s == s.MEDIUMUP)
			this.skyscraperList.add(new Skyscraper(skyscraperX, medSspY,width,mHeight,skyscraperd));
		else if(s == s.SMALLUP)
			this.skyscraperList.add(new Skyscraper(skyscraperX, smlSspY,width,sHeight,skyscraper));
		else if(s == s.SMALLDOWN)
			this.skyscraperList.add(new Skyscraper(skyscraperX, smlSspDwnY,width,sHeight,skyscraperd));
	}

	public void moveAll() {
		for(int i = 0; i < skyscraperList.size(); i ++) {			
			skyscraperList.get(i).move();
		}				
	}

	public Boolean checkCollideAll(Character character) {
		
		Boolean collide = false;
		
		for(int i = 0; i < skyscraperList.size(); i++) {
			 
			collide = skyscraperList.get(i).checkCollide(character.getRightX()
					, character.getLeftX(), character.getTopY(), character.getBottomY());
			
			if(collide)
				return collide;
		}
		
		return collide;
	}

	public void paintAll(Graphics g) {
		for(int i = 0; i < skyscraperList.size(); i ++) {
			skyscraperList.get(i).paint(g);
		}
	}
}
