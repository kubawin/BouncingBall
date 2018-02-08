import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;

public class CrashListener implements BallEventListener {

	Random rnd;
	float r;
	float g;
	float b;

	@Override
	public void hit(BallEvent e) {
		JPanel o = (JPanel) e.getSource();
		Random rnd = new Random();
		r = rnd.nextFloat();
		g = rnd.nextFloat();
		b = rnd.nextFloat();
		Color randomColor = new Color(r, g, b);
		o.setBackground(randomColor);
	}

}
