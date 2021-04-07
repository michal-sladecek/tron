import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class yourclass extends Core implements KeyListener, MouseListener,
		MouseMotionListener {

	Player player1 = new Player(new Coordinates(40,40), Player.Direction.RIGHT);
	Player player2 = new Player(new Coordinates(600,440), Player.Direction.LEFT);

	int moveAmount = 5;

	public void init() {
		super.init();

		Window w = sm.getFullScreenWindow();
		w.addKeyListener(this);
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
		drawPlayerPath(g, player1.path, Color.green);
		drawPlayerPath(g, player2.path, Color.red);
	}

	private void updateGameState() {
		movePlayers();
		checkForCollisions();
		updatePlayerPaths();
	}

	private void updatePlayerPaths() {
		player1.updatePath();
		player2.updatePath();
	}

	private void movePlayers() {
		player1.movePlayer(moveAmount,sm.getWidth(),sm.getHeight());
		player2.movePlayer(moveAmount,sm.getWidth(),sm.getHeight());
	}

	private void checkForCollisions() {
		if(		player1.checkCollision(player1) ||
				player1.checkCollision(player2) ||
				player2.checkCollision(player1) ||
				player2.checkCollision(player2)){
			System.exit(0);
		}
	}

	private void drawPlayerPath(Graphics2D g, ArrayList<Coordinates> playerPath, Color color) {
		for (int x = 0; x < playerPath.size(); x++) {
			g.setColor(color);
			g.fillRect(playerPath.get(x).getX(), playerPath.get(x).getY(), 10, 10);
		}
	}

	private void movePlayer(Player.Direction direction, Coordinates location) {
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


	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player1.setDirectionUP();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player1.setDirectionDOWN();
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player1.setDirectionRIGHT();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player1.setDirectionLEFT();
		}

		if (e.getKeyCode() == KeyEvent.VK_W) {
			player2.setDirectionUP();
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			player2.setDirectionDOWN();
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			player2.setDirectionRIGHT();
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			player2.setDirectionLEFT();
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent arg0) {

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
