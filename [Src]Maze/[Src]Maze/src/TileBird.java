import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.sun.prism.Image;

public class TileBird extends JPanel{
	int x, y;
    boolean isWall = true;
    public BufferedImage bird = null;
    
    public TileBird(int x, int y) throws IOException{
        this.x = x;
        this.y = y;
        bird = ImageIO.read(new File("res/Images/bird.png"));
    }
    
    public void setWall(boolean isWall){
        this.isWall = isWall;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bird, 0, 0, this);
    }
}
