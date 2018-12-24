import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.sun.prism.Image;

public class TileDoor extends JPanel{
	int x, y;
    boolean isWall = true;
    public BufferedImage door = null;
    
    public TileDoor(int x, int y) throws IOException{
        this.x = x;
        this.y = y;
        door = ImageIO.read(new File("res/Images/tile_door2.png"));
    }
    
    public void setWall(boolean isWall){
        this.isWall = isWall;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(door, 0, 0, this);
    }
}
