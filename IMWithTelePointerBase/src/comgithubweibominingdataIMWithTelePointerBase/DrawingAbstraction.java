package comgithubweibominingdataIMWithTelePointerBase;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class DrawingAbstraction extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2706838155739712076L;
	private JFrame frame = null;

	public DrawingAbstraction(JFrame frame) {
		// TODO Auto-generated constructor stub
		super(null);
		this.setFrame(frame);
		setOpaque(false);
	}

	public DrawingAbstraction(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public DrawingAbstraction(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public DrawingAbstraction(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void paintComponent(Graphics g);

    /**
     * If someone adds a mouseListener to the GlassPane or set a new cursor
     * we expect that he knows what he is doing
     * and return the super.contains(x, y)
     * otherwise we return false to respect the cursors
     * for the underneath components
     */
    public boolean contains(int x, int y) {
        if (getMouseListeners().length == 0 && getMouseMotionListeners().length == 0
                && getMouseWheelListeners().length == 0
                && getCursor() == Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)) {
            return false;
        }
        return super.contains(x, y);
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
