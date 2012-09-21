package comgithubweibominingdataIMWithTelePointerBase;

import java.awt.AWTEvent;
import java.awt.Point;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

public abstract class EventprocessingAbstraction implements AWTEventListener {
	private DrawingAbstraction panel;
	private Point point = new Point();

	public EventprocessingAbstraction(DrawingAbstraction p) {
		// TODO Auto-generated constructor stub
		this.panel = p;
	}

	@Override
	public void eventDispatched(AWTEvent event) {
		// TODO Auto-generated method stub
        if (event instanceof MouseEvent) {
            MouseEvent me = (MouseEvent) event;
            if (!SwingUtilities.isDescendingFrom(me.getComponent(), panel.getFrame())) {
                return;
            }
            if (me.getID() == MouseEvent.MOUSE_EXITED && me.getComponent() == panel.getFrame()) {
                setPoint(null);
            } else {
                MouseEvent converted = SwingUtilities.convertMouseEvent(me.getComponent(), me, panel);
                setPoint(converted.getPoint());
            }
            panel.repaint();
        }

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

}
