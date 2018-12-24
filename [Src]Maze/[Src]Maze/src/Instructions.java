import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Instructions extends JFrame{
	
	public Instructions()
	{
		String str = "Basic Mase game: Use W A S D to navigate and find the exit path";
		JTextArea text = new JTextArea(str);
		text.setVisible(true);
		this.setSize(500, 500);
		this.add(text);
	    this.setTitle("Instructions");
	    //this.setLayout(null);
	    this.setVisible(true);
	    repaint();
	}
}
