import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class yourclass extends Core implements  MouseListener,
		MouseMotionListener {

	TronPlayer tronPlayer1;
	TronPlayer tronPlayer2;

	TronPlayerControl control1;
	TronPlayerControl control2;

	int moveAmount = 5;

	public void init() {
		super.init();

		Window w = sm.getFullScreenWindow();

		tronPlayer1 = new TronPlayer(new Coordinates(40,40), TronPlayer.Direction.RIGHT);
		tronPlayer2 = new TronPlayer(new Coordinates(600,440), TronPlayer.Direction.LEFT);

		control1 = new TronPlayerControl(tronPlayer1,KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_RIGHT,KeyEvent.VK_LEFT);
		control2 = new TronPlayerControl(tronPlayer2,KeyEvent.VK_W,KeyEvent.VK_S,KeyEvent.VK_D,KeyEvent.VK_A);

		w.addKeyListener(control1);
		w.addKeyListener(control2);


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
		drawPlayerPath(g, tronPlayer1.path, Color.green);
		drawPlayerPath(g, tronPlayer2.path, Color.red);
	}

	private void updateGameState() {
		movePlayers();
		checkForCollisions();
		updatePlayerPaths();
	}

	private void updatePlayerPaths() {
		tronPlayer1.updatePath();
		tronPlayer2.updatePath();
	}

	private void movePlayers() {
		tronPlayer1.movePlayer(moveAmount,sm.getWidth(),sm.getHeight());
		tronPlayer2.movePlayer(moveAmount,sm.getWidth(),sm.getHeight());
	}

	private void checkForCollisions() {
		if(		tronPlayer1.checkCollision(tronPlayer1) ||
				tronPlayer1.checkCollision(tronPlayer2) ||
				tronPlayer2.checkCollision(tronPlayer1) ||
				tronPlayer2.checkCollision(tronPlayer2)){
			System.exit(0);
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
