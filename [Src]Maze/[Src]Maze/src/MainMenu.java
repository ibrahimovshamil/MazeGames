
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author student
 */
public class MainMenu {
    JFrame Menu = new JFrame("Maze");
    JButton Start = new JButton("Play");
    JButton Exit = new JButton("Exit");
    JButton instr = new JButton("Instructions");
    JButton settings = new JButton("Settings");
    ArrayList<String> mapList = new ArrayList<String>();
    JComboBox<String> lvlList;
    int menuWidth = 100; //Width of each button/item on display
    int menuHeight = 30;//Height of each button/item on display
    int menuY = 460; //Button/item location on display
    int WIDTH = 490;
    int HEIGHT = 530;
    
            
	public MainMenu() {
    	//Load map list
    	getMapList();
    	lvlList = new JComboBox<String>(mapList.toArray(new String[mapList.size()]));
    	
    	settings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new Settings();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("hey");
			}
		});
    	
    	instr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Instructions();
				//System.out.println("hey");
			}
		});
    	
        //Menu Variables
        Menu.setResizable(false);
        Menu.setSize(WIDTH, HEIGHT);
        Menu.setLayout(null);
        Menu.setLocationRelativeTo(null);
        Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Start Button Variables
        Start.setBounds(125, 125, 250, 250);
        Start.setVisible(true);
        Menu.add(Start);
        Menu.setVisible(true);
        Start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//if(lvlList.getSelectedItem().toString().equals("Level 0.map"))
					try {
						new Maze(lvlList.getSelectedItem().toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(lvlList.getSelectedItem().toString());
				Menu.setVisible(false);
			}
        	
        });	

        //Level Selector
        lvlList.setSize(menuWidth+35, menuHeight);
        lvlList.setLocation(230, menuY);
        Menu.add(lvlList);
        
        // Instructions button
        instr.setSize(menuWidth,menuHeight);
        instr.setLocation(30, menuY);
        Menu.add(instr);
        //Settings button
        settings.setSize(menuWidth,menuHeight);
        settings.setLocation(30, 400);
        Menu.add(settings);
        //Exit Button Variables
        Exit.setSize(menuWidth,menuHeight);
        Exit.setLocation(375,menuY);
        Menu.add(Exit);
        Exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
	            System.exit(0);
			}
        });
    }

    static boolean levelsExistAlready = false;

    public void getMapList(){
    	for(int i = 0; i < 99; i++){
    		File map = new File("./Level "+i+".map");
    		if(map.exists()){
    			System.out.println("Level "+i+" exists");
    			mapList.add("Level "+i+".map");
    			levelsExistAlready = true;
    		}
    	}
    }
}
