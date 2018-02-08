import java.util.EventListener;

import javax.swing.JPanel;

public interface BallEventListener extends EventListener {
	public abstract void hit(BallEvent e);

}
