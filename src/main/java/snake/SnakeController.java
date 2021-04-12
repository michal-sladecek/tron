package snake;

import engine.GameControl;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class SnakeController extends GameControl {

    SnakeHead head;
    int up,down,right,left;

    public SnakeController(SnakeHead head, int up, int down, int right, int left) {
        this.head = head;
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == this.up) {
            head.setDirectionUP();
        } else if (e.getKeyCode() == this.down) {
            head.setDirectionDOWN();
        } else if (e.getKeyCode() == this.right) {
            head.setDirectionRIGHT();
        } else if (e.getKeyCode() == this.left) {
            head.setDirectionLEFT();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
