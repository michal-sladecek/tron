import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class yourclass extends Core implements KeyListener, MouseListener,
		MouseMotionListener {
	Coordinates locationOfPlayer1 = new Coordinates(40,40);
	Coordinates locationOfPlayer2 = new Coordinates(600,440);
	ArrayList<Coordinates> pathOfPlayer1 = new ArrayList<Coordinates>();
	ArrayList<Coordinates> pathOfPlayer2 = new ArrayList<Coordinates>();

	int currentDirection1 = 1;
	int currentDirection2 = 3;
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
		movePlayer(currentDirection1,locationOfPlayer1);
		movePlayer(currentDirection2, locationOfPlayer2);

		checkForCollisions();

		pathOfPlayer1.add(new Coordinates(locationOfPlayer1));
	    pathOfPlayer2.add(new Coordinates(locationOfPlayer2));
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, sm.getWidth(), sm.getHeight());
		drawPlayerPath(g, pathOfPlayer1, Color.green);
		drawPlayerPath(g, pathOfPlayer2, Color.red);
	}

	private void checkForCollisions() {
		for(int x=0;x<pathOfPlayer1.size();x++){
			if(locationOfPlayer1.equals(pathOfPlayer1.get(x)) || locationOfPlayer2.equals(pathOfPlayer1.get(x))){
				System.exit(0);
			}
		}

		for(int x=0;x<pathOfPlayer2.size();x++){
			if(locationOfPlayer1.equals(pathOfPlayer2.get(x)) || locationOfPlayer2.equals(pathOfPlayer2.get(x))){
				System.exit(0);
			}
		}
	}

	private void drawPlayerPath(Graphics2D g, ArrayList<Coordinates> playerPath, Color color) {
		for (int x = 0; x < playerPath.size(); x++) {
			g.setColor(color);
			g.fillRect(playerPath.get(x).getX(), playerPath.get(x).getY(), 10, 10);
		}
	}

	private void movePlayer(int direction, Coordinates location) {
		switch(direction){
		case 0:
			if (location.getY()>0){
				location.move(0,-moveAmount);
			} else {
				location.setY(sm.getHeight());
			}
			break;
		case 1:
			if (location.getX() < sm.getWidth()){
				location.move(moveAmount,0);
			} else {
				location.setX(0);
			}
			break;
		case 2:
			if (location.getY() < sm.getHeight()){
				location.move(0,moveAmount);
			} else {
				location.setY(0);
			}
			break;
		case 3:
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
			if (currentDirection1 != 2){
			currentDirection1 = 0;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (currentDirection1 != 0){
				currentDirection1 = 2;
				}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (currentDirection1 != 3){
				currentDirection1 = 1;
				}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (currentDirection1 != 1){
				currentDirection1 = 3;
				}
		}
		if (e.getKeyCode() == KeyEvent.VK_W){
			if (currentDirection2 != 2){
			currentDirection2 = 0;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			if (currentDirection2 != 0){
				currentDirection2 = 2;
				}
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			if (currentDirection2 != 3){
				currentDirection2 = 1;
				}
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			if (currentDirection2 != 1){
				currentDirection2 = 3;
				}
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
