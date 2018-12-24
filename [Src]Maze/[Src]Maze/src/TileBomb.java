import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.sun.prism.Image;

public class TileBomb extends JPanel{
	int x, y;
    boolean isWall = true;
    public BufferedImage bomb = null;
    
    public TileBomb(int x, int y) throws IOException{
        this.x = x;
        this.y = y;
        bomb = ImageIO.read(new File("res/Images/bomb.png"));
    }
    
    public void setWall(boolean isWall){
        this.isWall = isWall;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bomb, 0, 0, this);
    }
}
