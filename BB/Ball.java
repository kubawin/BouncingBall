import java.awt.Color;

import javax.swing.JPanel;

public class Ball extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 102;
	private static final int SMALLDIM = 25;

	Ball() {
		
		setSize(SMALLDIM, SMALLDIM);
		setBackground(Color.BLACK);

		setLocation(250,250);
	}
	
	
}
