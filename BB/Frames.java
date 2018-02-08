
import javax.swing.JFrame;

public class Frames extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 101;
	private static final int FRAME_SIZE = 500;
	
	Boisko big;

	Frames() {
		Ball b = new Ball();
		big = new Boisko(b);

		 
		CrashListener cl = new CrashListener();
		big.addBallListener(cl);
		getContentPane().add(big);
		setSize(FRAME_SIZE, FRAME_SIZE);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public int getSizeFrame() {
		return FRAME_SIZE;
	}

}	

