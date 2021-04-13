package tron;

import engine.GameControl;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class TronPlayerMouseControl extends GameControl  {

    TronPlayer player;

    int rotateLeft, rotateRight;
    public TronPlayerMouseControl(TronPlayer player, int rotateLeft, int rotateRight) {
        this.player = player;

        this.rotateLeft = rotateLeft;
        this.rotateRight = rotateRight;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == this.rotateLeft)
            player.rotateLeft();
        else if (e.getButton() == this.rotateRight)
            player.rotateRight();
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
    //mouse motion
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
