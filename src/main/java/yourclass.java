import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.*;
import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;

public class yourclass implements  MouseListener,
		MouseMotionListener {

	Engine engine = new Engine();

	private void setupPlayers() {

		ArrayList<GameObject> players = new ArrayList<>();
		ArrayList<KeyListener> controls  = new ArrayList<>();

		TronPlayer p1 = new TronPlayer(new Coordinates(40,40), TronPlayer.Direction.RIGHT, Color.green);
		TronPlayer p2 = new TronPlayer(new Coordinates(600,440), TronPlayer.Direction.LEFT, Color.red);
		TronPlayer p3 = new TronPlayer(new Coordinates(900,500), TronPlayer.Direction.UP, Color.yellow);

		players.add(p1);
		players.add(p2);
		players.add(p3);

		controls.add((new TronPlayerControl(p1, KeyEvent.VK_UP,KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT)));
		controls.add((new TronPlayerControl(p2, KeyEvent.VK_W,KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_A)));

		engine.setGameObjects(players);
		engine.setControls(controls);
	}

	public static void main(String[] args) {
		yourclass y = new yourclass();
		y.setupPlayers();
		y.engine.run();
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {

	}
}
