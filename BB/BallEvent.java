import java.awt.AWTEvent;

public class BallEvent extends AWTEvent {
	/**
	* 
	*/
	private static final long serialVersionUID = -7114581090227625168L;
	/**
	* 
	*/

	public static final int GAME_EVENT = AWTEvent.RESERVED_ID_MAX + 123;

	public static enum BallEventType {
		HIT_TOP, HIT_BOTTOM, HIT
	};

	private BallEventType type = BallEventType.HIT;

	public BallEvent(Object source,BallEventType t) {
		super(source, GAME_EVENT);
		type = t;
	}

	public BallEventType getEventType() {
		return type;
	}
}
