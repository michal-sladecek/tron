import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;

public class yourclass extends Core implements  MouseListener,
		MouseMotionListener {

	ArrayList<TronPlayer> players = new ArrayList<>();
	ArrayList<TronPlayerControl> controls  = new ArrayList<>();

	int moveAmount = 5;

	public void init() {
		super.init();

		Window w = sm.getFullScreenWindow();

		players.add(new TronPlayer(new Coordinates(40,40), TronPlayer.Direction.RIGHT, Color.green));
		players.add(new TronPlayer(new Coordinates(600,440), TronPlayer.Direction.LEFT, Color.red));

		controls.add(new TronPlayerControl(players.get(0),KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_RIGHT,KeyEvent.VK_LEFT));
		controls.add(new TronPlayerControl(players.get(1),KeyEvent.VK_W,KeyEvent.VK_S,KeyEvent.VK_D,KeyEvent.VK_A));

		for (TronPlayerControl x: controls) {
			w.addKeyListener(x);
		}

		w.addMouseListener(this);
		w.addMouseMotionListener(this);
	}

	public static void main(String[] args) {
		new yourclass().run();
	}

	public void draw(Graphics2D g) {
		updateGameState();
		drawGameState(g);
	}

	private void drawGameState(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, sm.getWidth(), sm.getHeight());
		for (TronPlayer player: players) {
			drawPlayerPath(g,player.path,player.color);
		}
	}

	private void updateGameState() {
		movePlayers();
		checkForCollisions();
		updatePlayerPaths();
	}

	private void updatePlayerPaths() {
		for (TronPlayer player: players) {
			player.updatePath();
		}
	}

	private void movePlayers() {
		for (TronPlayer player: players) {
			player.movePlayer(moveAmount,sm.getWidth(), sm.getHeight());
		}
	}

	private void checkForCollisions() {
		for (TronPlayer player1: players) {
			for (TronPlayer player2: players) {
				if(player1.checkCollision(player2)){
					System.exit(0);
				}
			}
		}
	}

	private void drawPlayerPath(Graphics2D g, ArrayList<Coordinates> playerPath, Color color) {
		for (int x = 0; x < playerPath.size(); x++) {
			g.setColor(color);
			g.fillRect(playerPath.get(x).getX(), playerPath.get(x).getY(), 10, 10);
		}
	}

	private void movePlayer(TronPlayer.Direction direction, Coordinates location) {
		switch(direction){
		case UP:
			if (location.getY()>0){
				location.move(0,-moveAmount);
			} else {
				location.setY(sm.getHeight());
			}
			break;
		case RIGHT:
			if (location.getX() < sm.getWidth()){
				location.move(moveAmount,0);
			} else {
				location.setX(0);
			}
			break;
		case DOWN:
			if (location.getY() < sm.getHeight()){
				location.move(0,moveAmount);
			} else {
				location.setY(0);
			}
			break;
		case LEFT:
			if (location.getX()>0){
				location.move(-moveAmount,0);
			} else {
				location.setX(sm.getWidth());
			}
			break;
		}
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
