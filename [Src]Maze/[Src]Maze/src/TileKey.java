import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.sun.prism.Image;

public class TileKey extends JPanel{
	int x, y;
    boolean isWall = true;
    public BufferedImage key = null;
    
    public TileKey(int x, int y) throws IOException{
        this.x = x;
        this.y = y;
        key = ImageIO.read(new File("res/Images/key.png")); //
    }
    public void setWall(boolean isWall){
        this.isWall = isWall;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(key, 0, 0, this);
    }
}
