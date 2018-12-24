import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Player1 extends JPanel{
	int xp, yp;
	int point = 0;
	int live = 1;
	int key = 0;
	public BufferedImage player = null;
	TileBomb bomb = null;
	File wavFile = new File("res/button-4.wav");
	File wavFile1 = new File("res/button-6.wav");
	File wavFile2 = new File("res/button-7.wav");
	File wavFile3 = new File("res/button-09.wav");
	boolean soundFlag = true;
	boolean liveUp = true;
	AudioClip click = Applet.newAudioClip(wavFile.toURL());
	AudioClip click1 = Applet.newAudioClip(wavFile1.toURL());
	AudioClip click2 = Applet.newAudioClip(wavFile2.toURL());
	AudioClip click3 = Applet.newAudioClip(wavFile3.toURL());
	int product;
	//soundFlag = false;
	//liveUp = false;
	
    public Player1(int product) throws IOException {
    	//this.setBackground(Color.getHSBColor(0.3f, 0.3f, 1));
    	this.product= product;
    	this.xp = xp;
    	this.yp = yp;
    	this.live = live;
    	this.key = key;
    	this.bomb = bomb;
    	System.out.println("PRODUCT: " + product);
    	if(product == 0)
    		player = ImageIO.read(new File("res/Images/green.png"));
    	else player = ImageIO.read(new File("res/Images/tile_player_idle_Right.png"));
    	this.setSize(Maze.panelSize, Maze.panelSize);
    }
    
    public void moveLeft() throws IOException {
    	//click = Applet.newAudioClip(wavFile.toURL());
    	if(soundFlag)
    		click.play();
    	if(xp > 0 && Maze.M[yp][xp-1] == 1){
	    	this.setLocation(this.getX()-25, this.getY());
	    	xp--;
    	}
    	else if(xp > 0 && Maze.M[yp][xp-1] == 2)
    	{
    		point = point + 10;
    		if(liveUp)live = live + 1;
	    	this.setLocation(this.getX()-25, this.getY());
	    	xp--;
    	}
    	else if(xp > 0 && Maze.M[yp][xp-1] == 5)
    	{	
    		if(key > 0 && product == 2 )
    			showMessage();
    		else if(product != 2) showMessage();
    	}
    	if(product == 1 || product == 2 )
    	{
    		if( live == 1)
    		{
            	if(xp > 0 && Maze.M[yp][xp-1] == 3)
            	{
            		JOptionPane.showMessageDialog(null, "You lost!!!", "End Game", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else if(xp > 0 && Maze.M[yp][xp-1] == 4)
            	{
            		JOptionPane.showMessageDialog(null, "You lost!!!", "End Game", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else if(xp > 0 && Maze.M[yp][xp-1] == 6)
            	{
            		JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else if(xp > 0 && Maze.M[yp][xp-1] == 8)
            	{
            		JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else if(xp > 0 && Maze.M[yp][xp-1] == 9)
            	{
            		//JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
            		key = key + 1;
            		System.out.println("KEY: " + key);
            	}
    		}
    		else
    		{
//    			live = live-1;
//            	if(xp > 0 && Maze.M[yp][xp-1] == 9)
//            	{
//            		//JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
//            		key = key + 1;
//            		System.out.println("KEY: " + key);
//            	}
    		}

    	}

    }

    public void moveRight() throws IOException {
    	if(soundFlag)
    		click1.play();
    	
    	if(xp < Maze.C-1 && Maze.M[yp][xp+1] == 1){
    		System.out.println("Maze.R: " + Maze.R);
	    	this.setLocation(this.getX()+25, this.getY());
	    	xp++;
    	}
    	else if(xp < Maze.C-1 && Maze.M[yp][xp+1]  == 2)
    	{
    		point = point + 10;
    		if(liveUp)
    		{
    			live = live + 1;
    			System.out.println("Live: " + live);
    		}
	    	this.setLocation(this.getX()+25, this.getY());
	    	xp++;
    	}
    	else if(xp < Maze.C-1 && Maze.M[yp][xp+1]  == 5)
    	{
    		System.out.println("KEYif: " + key);
    		if(key > 0 && product == 2 )
    			showMessage();
    		else if(product != 2) showMessage();
    	}
    	if(product == 1 || product == 2)
    	{
    		if( live == 1)
    		{
    			System.out.println("Live inside of if: " + live);
    			if(xp < Maze.C-1 && Maze.M[yp][xp+1] == 3)
            	{
            		JOptionPane.showMessageDialog(null, "You lost!!!", "End Game", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else if(xp < Maze.C-1 && Maze.M[yp][xp+1] == 4)
            	{
            		JOptionPane.showMessageDialog(null, "You lost!!!", "End Game", JOptionPane.INFORMATION_MESSAGE);
            	}

            	else if(xp < Maze.C-1 && Maze.M[yp][xp+1] == 6)
            	{
            		JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else if(xp < Maze.C-1 && Maze.M[yp][xp+1] == 8)
            	{
            		JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else if(xp < Maze.C-1 && Maze.M[yp][xp+1] == 9)
            	{
            		//JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
            		key = key +1;
            	}
    		}
    		else if(live > 1)
    		{
    			System.out.println("ELSE");
    			
    			if(xp < Maze.C-1 && Maze.M[yp][xp+1] == 3)
            	{
            		//JOptionPane.showMessageDialog(null, "You lost!!!", "End Game", JOptionPane.INFORMATION_MESSAGE);
            		live = live -1;
            	}
            	else if(xp < Maze.C-1 && Maze.M[yp][xp+1] == 4)
            	{
            		live = live -1;
            		//JOptionPane.showMessageDialog(null, "You lost!!!", "End Game", JOptionPane.INFORMATION_MESSAGE);
            	}

            	else if(xp < Maze.C-1 && Maze.M[yp][xp+1] == 6)
            	{
            		live = live -1;
            		//JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else if(xp < Maze.C-1 && Maze.M[yp][xp+1] == 8)
            	{
            		live = live -1;
            		//JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else if(xp < Maze.C-1 && Maze.M[yp][xp+1] == 9)
            	{
            		//live = live -1;
            		//JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
            		key = key +1;
            	}
    		}
        	
    	}

    }

    public void moveUp() throws IOException {
    	if(soundFlag)
    		click2.play(); 	
    	if(yp > 0 && Maze.M[yp-1][xp] == 1){
    		//System.out.println("hey");
	    	this.setLocation(this.getX(), this.getY()-25);
	    	System.out.println("COORD: " + this.getX() + ": " + (this.getY()-25));
	    	yp--;
    	}
    	else if(yp > 0 && Maze.M[yp-1][xp] == 2)
    	{
    		point = point + 10;
	    	this.setLocation(this.getX(), this.getY()-25);
	    	yp--;
    	}
    	else if(yp > 0 && Maze.M[yp-1][xp] == 5)
    	{
    		if(key > 0 && product == 2 )
    			showMessage();
    		else if(product != 2) showMessage();
    	}
    	if(product == 1 || product == 2)
    	{
    		if(yp > 0 && Maze.M[yp-1][xp] == 3)
        	{
        		JOptionPane.showMessageDialog(null, "You lost!!!", "End Game", JOptionPane.INFORMATION_MESSAGE);
        	}
        	else if(yp > 0 && Maze.M[yp-1][xp] == 4)
        	{
        		JOptionPane.showMessageDialog(null, "You lost!!!", "End Game", JOptionPane.INFORMATION_MESSAGE);
        	}

        	else if(yp > 0 && Maze.M[yp-1][xp] == 6)
        	{
        		JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
        	}
        	else if(yp > 0 && Maze.M[yp-1][xp] == 8)
        	{
        		JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
        	}
    	}
    	
    }

    public void moveDown() throws IOException {
    	if(soundFlag)
    		click3.play();
    	if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 1){
	    	this.setLocation(this.getX(), this.getY()+25);
	    	yp++;
    	}
    	else if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 2)
    	{
    		point = point + 10;
	    	this.setLocation(this.getX(), this.getY()+25);
	    	yp++;
    	}
    	else if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 5)
    	{
    		if(key > 0 && product == 2 )
    			showMessage();
    		else if(product != 2) showMessage();
    	}
    	if(product == 1 || product == 2)
    	{
        	if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 3)
        	{
        		JOptionPane.showMessageDialog(null, "You lost!!!", "End Game", JOptionPane.INFORMATION_MESSAGE);
        	}
        	else if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 4)
        	{
        		JOptionPane.showMessageDialog(null, "You lost!!!", "End Game", JOptionPane.INFORMATION_MESSAGE);
        	}

        	else if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 6)
        	{
        		JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
        	}
        	else if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 8)
        	{
        		JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
        	}
    	}

    }
    
    public void putBomb() throws IOException {
    	//click = Applet.newAudioClip(wavFile3.toURL());
    	//click3.play();
    	if(Maze.M[yp][xp] == 1){
    		System.out.println("BOMB");
    		bomb = new TileBomb(xp,yp);
	    	bomb.setLocation(this.getX()+25, this.getY()+25);
	    	//yp++;
    	}
//    	else if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 2)
//    	{
//    		point = point + 10;
//	    	this.setLocation(this.getX(), this.getY()+25);
//	    	yp++;
//    	}
//    	else if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 5)
//    	{
//    		if(key > 0 && product == 2 )
//    			showMessage();
//    		else if(product != 2) showMessage();
//    	}
//    	if(product == 1 || product == 2)
//    	{
//        	if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 3)
//        	{
//        		JOptionPane.showMessageDialog(null, "You lost!!!", "End Game", JOptionPane.INFORMATION_MESSAGE);
//        	}
//        	else if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 4)
//        	{
//        		JOptionPane.showMessageDialog(null, "You lost!!!", "End Game", JOptionPane.INFORMATION_MESSAGE);
//        	}
//
//        	else if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 6)
//        	{
//        		JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
//        	}
//        	else if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 8)
//        	{
//        		JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
//        	}
//    	}

    }
    public void gravity(int val) throws IOException {
    	if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 1){
	    	this.setLocation(this.getX(), this.getY()+25);
	    	yp++;
    	}
    	else if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 2)
    	{
    		point = point + 10;
	    	this.setLocation(this.getX(), this.getY()+25);
	    	yp++;
    	}
    	else if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 5)
    	{
    		if(key > 0 && product == 2 )
    			showMessage();
    		else if(product != 2) showMessage();
    	}
    	if(product == 1)
    	{
        	if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 3)
        	{
        		JOptionPane.showMessageDialog(null, "You lost!!!", "End Game", JOptionPane.INFORMATION_MESSAGE);
        	}
        	else if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 4)
        	{
        		JOptionPane.showMessageDialog(null, "You lost!!!", "End Game", JOptionPane.INFORMATION_MESSAGE);
        	}

        	else if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 6)
        	{
        		JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
        	}
         	else if(yp < Maze.R-1 && Maze.M[yp+1][xp] == 8)
        	{
        		JOptionPane.showMessageDialog(null, "You lost ", "End Game", JOptionPane.INFORMATION_MESSAGE);
        	}
    	}

    }
    
    public void showMessage() throws IOException
    {
		if(Maze.count == 0)
		{
			JOptionPane.showMessageDialog(null, "Congratulations, you've beaten the level with point of" + point, "End Game", JOptionPane.INFORMATION_MESSAGE);
			//dispose();
			new MainMenu();
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "You Won with point of " + point, "End Game", JOptionPane.INFORMATION_MESSAGE);
    		if(Maze.count == 1) new Maze("Level 2.map");
    		else if(Maze.count == 2) new Maze("Level 3.map");
    		else if(Maze.count == 3)
    		{
    			JOptionPane.showMessageDialog(null, "Congratulations, you've beaten the level with point of" + point, "End Game", JOptionPane.INFORMATION_MESSAGE);
				//this.dispose();
				new MainMenu();
    		}
		}
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(player, 0, 0, this);
    }
}
