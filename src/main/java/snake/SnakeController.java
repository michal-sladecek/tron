package snake;

import engine.KeyboardController;
import java.awt.event.KeyEvent;

public class SnakeController extends KeyboardController {
    SnakeHead player;
    int up,down,right,left;


    public SnakeController(SnakeHead player, int up, int down, int right, int left) {
        this.player = player;

        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
    }


    //keyboard
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == this.up) {
            player.setDirectionUP();
        } else if (e.getKeyCode() == this.down) {
            player.setDirectionDOWN();
        } else if (e.getKeyCode() == this.right) {
            player.setDirectionRIGHT();
        } else if (e.getKeyCode() == this.left) {
            player.setDirectionLEFT();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
