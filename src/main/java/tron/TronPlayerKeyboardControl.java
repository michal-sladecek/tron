package tron;

import engine.GameControl;
import engine.KeyboardController;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class TronPlayerKeyboardControl extends KeyboardController {
    TronPlayer player;
    int up,down,right,left;


    public TronPlayerKeyboardControl(TronPlayer player, int up, int down, int right, int left) {
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
