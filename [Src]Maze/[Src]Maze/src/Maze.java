
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Maze extends JFrame{
	public static int rows = 20;
	public static int rows1 = 10;
	public static int columns = 20;
	public static int columns1 = 100;
	public static int panelSize = 25;
	public static int endLevelLoc;
	public static int R, C;
	public static int M[][];
	
	boolean gravFlag = true;
	boolean bombFlag = true;
	
	
	int product = 0;
	public static int count = 0;
	Player1 p1;
	String str;

	public Maze(String str) throws IOException{
		this.str = str;
		this.count = count;
//		gravFlag = false;
//		bombFlag = false;
		
		if(str.equals("Level 0.map"))
		{
			product = 0;
			this.setSize((columns*panelSize)+50, (rows*panelSize)+70);
			R = rows;C = columns;
			M = new int[R][C];
			loadMap(str, R, C);
		}
		else if(str.equals("Level 4.map"))
		{
			product = 2;
			this.setSize((columns*panelSize)+50, (rows*panelSize)+70);
			R = rows;C = columns;
			M = new int[R][C];
			loadMap(str, R, C);
		}
		else //change this part for a sure. else statement i mean ***************************************************************************
		{
			product = 1;
			this.setSize((columns1*panelSize)+50, (rows1*panelSize)+70);
			R = rows1;C = columns1;
			M = new int[R][C];
			loadMap(str, R, C);
			count++;
		}

		this.setResizable(true);
		this.setTitle("Maze");
		this.setLayout(null);
		p1 = new Player1(product);
		p1.setVisible(true);
		this.add(p1);

		this.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				revalidate();
				repaint();

				//Player movement
				if(p1.product == 2 && key == KeyEvent.VK_SPACE)
				{	try {
					System.out.println("SPACE");
					TileBomb bomb = new TileBomb(p1.xp, p1.yp);
					bomb.setSize(panelSize, panelSize);
					bomb.setLocation(98, 275);
					bomb.setVisible(true);
					add(bomb);
					//p1.putBomb();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//					p1.bomb.setSize(panelSize, panelSize);
//					p1.bomb.setVisible(true);
//					add(p1.bomb);
//					p1.bomb.setLocation((p1.xp*panelSize)+23, (p1.yp*panelSize)+25);
					revalidate();
					repaint();
				}
				if(key == KeyEvent.VK_W){
					if(product == 1)
					{
						//repaint();
						try {
							p1.moveUp();
							p1.moveUp();
							p1.moveUp();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else
					{
						try {
							p1.moveUp();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				if(key == KeyEvent.VK_A){
					try {
						p1.moveLeft();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(key == KeyEvent.VK_S){
					try {
						p1.moveDown();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(key == KeyEvent.VK_D){
					try {
						p1.moveRight();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub  				
			}
		});        
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setLocationRelativeTo(null);
		
		
		if(product == 1)
		{
			Timer timer = new Timer(500, new ActionListener() {
				int val = 0;
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						if(gravFlag == true)
						p1.gravity(25);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			timer.start();
		}
		//this.add(p1.bomb);
		System.out.println("R: " + R + " C: " + C);
		for(int y = 0; y < R; y++){
			for(int x = 0; x < C; x++){
				System.out.println("Y: " + y + " X: " + x);
				//System.out.println("X: " + x);
				if(M[y][x] == 0){
					TileBrick brick = new TileBrick(x, y);
					brick.setSize(panelSize, panelSize);
					brick.setLocation((x*panelSize)+23, (y*panelSize)+25);
					brick.setVisible(true);
					this.add(brick);
					//System.out.println();
				}else if(M[y][x] == 1){
					Tile tile = new Tile(x, y);
					tile.setSize(panelSize, panelSize);
					tile.setLocation((x*panelSize)+23, (y*panelSize)+25);
					tile.setBackground(Color.BLACK);
					tile.setWall(false);
					if(x == 0){
						p1.setLocation((x*panelSize)+23, (y*panelSize)+25);
						p1.yp = y;
					}
					if(x == C-1){
						endLevelLoc = y;
					}

					tile.setVisible(true);
					this.add(tile);
				}
				else if(M[y][x] == 2){
					TileDiamond diamond = new TileDiamond(x, y);
					diamond.setSize(panelSize, panelSize);
					diamond.setLocation((x*panelSize)+23, (y*panelSize)+25);
					diamond.setVisible(true);
					this.add(diamond);
				}
				else if(M[y][x] == 3){
					//tile.setBackground(Color.GREEN);
					TileFlame flame = new TileFlame(x, y);
					flame.setSize(panelSize, panelSize);
					flame.setLocation((x*panelSize)+23, (y*panelSize)+25);
					flame.setVisible(true);
					this.add(flame);
				}
				else if(M[y][x] == 4){
					//tile.setBackground(Color.ORANGE);
					TileWater water = new TileWater(x, y);
					water.setSize(panelSize, panelSize);
					water.setLocation((x*panelSize)+23, (y*panelSize)+25);
					water.setVisible(true);
					this.add(water);
				}
				else if(M[y][x] == 5){
					//tile.setBackground(Color.ORANGE);
					TileDoor door = new TileDoor(x, y);
					door.setSize(panelSize, panelSize);
					door.setLocation((x*panelSize)+23, (y*panelSize)+25);
					door.setVisible(true);
					this.add(door);
				}
				else if(M[y][x] == 6){
					//tile.setBackground(Color.ORANGE);
					TileEnemy enemy = new TileEnemy(x, y);
					enemy.setSize(panelSize, panelSize);
					enemy.setLocation((x*panelSize)+23, (y*panelSize)+25);
					enemy.setVisible(true);
					this.add(enemy);
				} //after this point
				else if(M[y][x] == 7){
					//tile.setBackground(Color.ORANGE);
					TileDestBrick dest = new TileDestBrick(x, y);
					dest.setSize(panelSize, panelSize);
					dest.setLocation((x*panelSize)+23, (y*panelSize)+25);
					dest.setVisible(true);
					this.add(dest);
				}
				else if(M[y][x] == 8){
					//tile.setBackground(Color.ORANGE);
					TileBird bird = new TileBird(x, y);
					bird.setSize(panelSize, panelSize);
					bird.setLocation((x*panelSize)+23, (y*panelSize)+25);
					bird.setVisible(true);
					this.add(bird);
				}
				else if(M[y][x] == 9){
					//tile.setBackground(Color.ORANGE);
					TileKey key = new TileKey(x, y);
					System.out.println("aha");
					System.out.println("X: "+ x + " Y: " + y);
					key.setSize(panelSize, panelSize);
					key.setLocation((x*panelSize)+23, (y*panelSize)+25);
					key.setVisible(true);
					this.add(key);
					
					if(product == 2 && bombFlag)
					{
						TileBomb bomb = new TileBomb(16, 8);
						bomb.setSize(panelSize, panelSize);
						bomb.setLocation((16*panelSize)+23, (8*panelSize)+25);
						bomb.setVisible(true);
						this.add(bomb);
					}
				}
			}
		}
		this.setVisible(true);
	}

	public static void main(String args[]){
		new MainMenu();
	}

	public void loadMap(String str, int rows, int columns){
		try{
			BufferedReader br = new BufferedReader(new FileReader(str));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String mapStr = sb.toString();

			int counter = 0;
			System.out.println("Colums: " + columns);
			System.out.println("raws: " + rows);
			for(int y = 0; y < rows; y++){
				for(int x = 0; x < columns; x++){
					System.out.println("YY: " + y);
					System.out.println("XX: " + x);
					String mapChar = mapStr.substring(counter, counter+1);
					if(!mapChar.equals("\r\n") && !mapChar.equals("\n")&& !mapChar.equals("\r")){//If it's a number
						// System.out.println("mapChar: " + mapChar);
						M[y][x] = Integer.parseInt(mapChar);
						System.out.println("mapChar: " + mapChar);
						
					}else{//If it is a line break
						x--;
						System.out.println("LINE BREAK");
						System.out.println(mapChar);
					}
					counter++;
				}
			}
		}catch(Exception e){
			System.out.println("Unable to load existing map(if exists), creating new map.");
		}
	}
}
