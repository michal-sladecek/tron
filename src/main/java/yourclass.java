import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;

public class yourclass implements  MouseListener,
		MouseMotionListener {

	Engine engine = new Engine();

	private void setupPlayers() {

		ArrayList<TronPlayer> players = new ArrayList<>();
		ArrayList<TronPlayerControl> controls  = new ArrayList<>();

		players.add(new TronPlayer(new Coordinates(40,40), TronPlayer.Direction.RIGHT, Color.green));
		players.add(new TronPlayer(new Coordinates(600,440), TronPlayer.Direction.LEFT, Color.red));
		players.add(new TronPlayer(new Coordinates(900,500), TronPlayer.Direction.UP, Color.yellow));

		controls.add(new TronPlayerControl(players.get(0),KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_RIGHT,KeyEvent.VK_LEFT));
		controls.add(new TronPlayerControl(players.get(1),KeyEvent.VK_W,KeyEvent.VK_S,KeyEvent.VK_D,KeyEvent.VK_A));

		engine.setPlayers(players);
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
