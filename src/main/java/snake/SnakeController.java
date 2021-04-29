package snake;

import engine.GameControl;
import engine.KeyboardController;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class SnakeController extends KeyboardController {

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
        System.out.println(e.getKeyChar());
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

}
