import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameScene extends JPanel{

	private final int width;
	private final int height;
	private int x;
	private int y;
	private ArrayList<Image> propsUp;
	private ArrayList<Image> propsDown;
	private ArrayList<Image> propsUpTree;
	private ArrayList<Image> propsDownTree;
	private Image cloudUp;
	private Image cloudDown;
	
	public GameScene(int w, int h)
	{
		width = 120000;//w * 100; //100����
		height = h;
		propsUp = new ArrayList<Image>();		
		propsDown = new ArrayList<Image>();
		propsUpTree = new ArrayList<Image>();
		propsDownTree = new ArrayList<Image>();
		loadImage();			
		
		this.setSize(width, height);
		this.setLayout(null);
		this.setBackground(new Color(214, 214, 194));
		setTree();
		setHouse();
		
	}
	
	private void setHouse() {
		
		int x = 0;
		int y = 640;
		
		while(x < width) {
			
			int index = (int)(Math.random() * propsUp.size());
			Image house = propsUp.get(index);
			HousePanel hp = new HousePanel(house);			
			
			
			this.add(hp);
			hp.setLocation(x, y);
			hp.setBackground(null);
			hp.setOpaque(false);
			hp.setSize(50,50);
			
			x += (int)(Math.random() * 10) + 40;
			
		}
		
		x = 0;
		y = 0;
		
		while(x < width) {
			
			int index = (int)(Math.random() * propsDown.size());
			Image house = propsDown.get(index);
			HousePanel hp = new HousePanel(house);			
			
			
			this.add(hp);
			hp.setLocation(x, y);
			hp.setBackground(null);
			hp.setOpaque(false);
			hp.setSize(50,50);
			
			x += (int)(Math.random() * 10) + 40;
			
		}
		
		
	}

	private void setTree() {
		int x = 0;
		int y = 660;
		
		while(x <= width) {
			int index = (int)(Math.random() * propsUpTree.size());
			Image tree = propsUpTree.get(index);
			TreePanel tp = new TreePanel(tree);
			
			this.add(tp);
			tp.setLocation(x, y);
			tp.setBackground(null);
			tp.setOpaque(false);
			tp.setSize(50,50);
			
			x += (int)(Math.random() * 70) + 120;
		}
		
		x = 0;
		y = 0;
		
		while(x <= width) {
			int index = (int)(Math.random() * propsDownTree.size());
			Image tree = propsDownTree.get(index);
			TreePanel tp = new TreePanel(tree);
			
			this.add(tp);
			tp.setLocation(x, y);
			tp.setBackground(null);
			tp.setOpaque(false);
			tp.setSize(50,50);
			
			x += (int)(Math.random() * 70) + 120;
		}
	}
	
	
	private void loadImage() {
		
		cloudDown = new ImageIcon(getClass().getResource("cloud.png")).getImage();
		cloudUp = new ImageIcon(getClass().getResource("cloudd.png")).getImage();
		
		
		propsUp.add(new ImageIcon(getClass().getResource("cabin.png")).getImage());
		propsUp.add(new ImageIcon(getClass().getResource("entrance.png")).getImage());
		propsUp.add(new ImageIcon(getClass().getResource("flats.png")).getImage());
		propsUp.add(new ImageIcon(getClass().getResource("hospital.png")).getImage());
		propsUp.add(new ImageIcon(getClass().getResource("house.png")).getImage());
		propsUp.add(new ImageIcon(getClass().getResource("roof.png")).getImage());
		propsUpTree.add(new ImageIcon(getClass().getResource("forest.png")).getImage());
		propsUpTree.add(new ImageIcon(getClass().getResource("tree.png")).getImage());
		propsUpTree.add(new ImageIcon(getClass().getResource("tree1.png")).getImage());
		propsUpTree.add(new ImageIcon(getClass().getResource("tree2.png")).getImage());
		
		
		propsDown.add(new ImageIcon(getClass().getResource("cabind.png")).getImage());
		propsDown.add(new ImageIcon(getClass().getResource("entranced.png")).getImage());
		propsDown.add(new ImageIcon(getClass().getResource("flatsd.png")).getImage());
		propsDown.add(new ImageIcon(getClass().getResource("hospitald.png")).getImage());
		propsDown.add(new ImageIcon(getClass().getResource("housed.png")).getImage());
		propsDown.add(new ImageIcon(getClass().getResource("roofd.png")).getImage());
		propsDownTree.add(new ImageIcon(getClass().getResource("forestd.png")).getImage());
		propsDownTree.add(new ImageIcon(getClass().getResource("treed.png")).getImage());
		propsDownTree.add(new ImageIcon(getClass().getResource("tree1d.png")).getImage());
		propsDownTree.add(new ImageIcon(getClass().getResource("tree2d.png")).getImage());
	}
	
	@Override public void paint(Graphics g) {
		super.paint(g);	
	}
	
}
