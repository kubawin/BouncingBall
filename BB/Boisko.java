import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JPanel;


public class Boisko extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 100;
	private static final int BIGDIM = 500;
	private static final int DELAY = 30;
	private static final int FRAME_SIZE = 500;
	private static final double GRAVITY = 0;
	private static final double BOUNCE_REDUCE = 1;
	private static final int RANDOM_BOUND_MAX = 5;
	private static final int RANDOM_BOUND_MIN = 5;

	Random rnd = new Random();
	private double xVel = rnd.nextInt(RANDOM_BOUND_MAX + 1 - RANDOM_BOUND_MIN) + RANDOM_BOUND_MIN;
	private double yVel = rnd.nextInt(RANDOM_BOUND_MAX + 1 - RANDOM_BOUND_MIN) + RANDOM_BOUND_MIN;

	Ball ball;

	Boisko(Ball sm){
		
		ball = sm;
		Thread t = new Thread(this);
		t.start();
		setLayout(null);
		setSize(BIGDIM, BIGDIM);
		setBackground(Color.LIGHT_GRAY);
		add(ball);

	}

	public void addBallListener(BallEventListener listener) {
		listenerList.add(BallEventListener.class, listener);
	}

	public void removeBallListener(BallEventListener listener) {
		listenerList.remove(BallEventListener.class, listener);
	}

	@Override
	public void processEvent(AWTEvent evt) {
		BallEventListener[] listeners = listenerList.getListeners(BallEventListener.class);
		if (evt instanceof BallEvent) {

			for (int i = 0; i < listeners.length; i++) {
				BallEvent ge = (BallEvent) evt;
				//switch (ge.getEventType()) {
				//case HIT_TOP:
					listeners[i].hit(ge);
				//	break;
//				case SIZE:
//					listeners[i].changeBallSize(ge);
//					break;
				//}
			}
		} else {
			super.processEvent(evt);
		}
	}

	@Override
	public void run() {
		
		while (true) {
			try {
				
				moveBall();
				checkForCollision();				

				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
			}
			
		}

	}

	public void moveBall() {
		ball.setLocation(ball.getX() + (int) xVel, ball.getY() + (int) yVel);
		yVel += GRAVITY;
	}

	private void checkForCollision() {
		EventQueue queue = Toolkit.getDefaultToolkit().getSystemEventQueue();
		if ((ball.getY() >= getHeight() - ball.getHeight() )||( ball.getY() <= 0)) {
			yVel = -yVel * BOUNCE_REDUCE;
			BallEvent ge = new BallEvent(this, BallEvent.BallEventType.HIT_TOP);
			queue.postEvent(ge);
		}
		if (ball.getX() >= getWidth()- ball.getWidth() || ball.getX() <= 0) {
			xVel = -xVel;
			BallEvent ge = new BallEvent(this, BallEvent.BallEventType.HIT_BOTTOM);
			queue.postEvent(ge);
		}

	}
}
