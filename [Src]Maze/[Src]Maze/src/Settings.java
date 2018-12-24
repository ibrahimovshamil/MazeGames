import java.awt.Dimension;
import java.awt.LayoutManager;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import com.sun.prism.paint.Color;

public class Settings extends JFrame{
	//public static Maze m; 
	public Settings() throws IOException
	{
		
	    ArrayList<String> mapList = new ArrayList<String>();
	    mapList.add("BLACK");
	    mapList.add("GREEN");
	    mapList.add("PURPLE");
	    mapList.add("WHITE");
	    JLabel key = new JLabel("Controller Key");
	    JComboBox<String> lvlList;
	    
	    lvlList = new JComboBox<String>(mapList.toArray(new String[mapList.size()]));
	    //lvlList.setPreferredSize(new Dimension(50, 50));
	    BoxLayout lay = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS); 
	    this.setSize(200, 200);
	    this.setLayout(lay);
	    this.setTitle("Settings");
	    
		String str = "Background: ";
		JLabel text = new JLabel(str);
		text.setVisible(true);
		text.setLocation(50, 50);
		this.add(text);

	    this.setLocation(50, 50);
	    this.add(lvlList);
	    
	    JLabel soundLb = new JLabel("Sound");
	    JRadioButton option1 = new JRadioButton("On/Off");
	    this.add(soundLb);
	    this.add(option1);
	    
	    this.add(key);
	    JRadioButton optionkey = new JRadioButton("On/Off");
	    this.add(optionkey);
	    
	    //m.str = "Level 0.map";
	    this.setVisible(true);
	    //pack();
	    repaint();
	}
}
