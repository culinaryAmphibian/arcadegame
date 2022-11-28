import java.awt.*;
import java.awt.event.*;

public class GameLoop extends Frame {
	final int WIDTH = 400;
	final int HEIGHT = 400;
	Lander lander;
	Landscape landscape;
    public GameLoop() {
        setSize(WIDTH, HEIGHT);
        setTitle("Moon Lander");
        setLayout(null);
        setVisible(true);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
        addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent ke) {

            }
            public void keyReleased(KeyEvent ke) {

            }
            public void keyTyped(KeyEvent ke) {

            }
        });
		lander = new Lander(this);
		landscape = new Landscape(WIDTH, HEIGHT);
		landscape.generateMore(true);
    }
	public void paint(Graphics g) {
		lander.update();
		lander.render(g);
		landscape.drawLandscape(g, lander.getPos());
	}
    public static void main(String[] args) {
        new GameLoop();
    }
}