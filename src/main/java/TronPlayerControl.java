import java.awt.event.*;

public class TronPlayerControl extends GameControl {
    TronPlayer player;

    boolean keyboard;
    int up,down,right,left;


    boolean mouseClick;
    int rotateLeft, rotateRight;
    //boolean mouseMotion;

    public TronPlayerControl(TronPlayer player, int up, int down, int right, int left) {
        this.player = player;

        this.keyboard = true;
        this.mouseClick = false;

        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
    }
    public TronPlayerControl(TronPlayer player, int rotateLeft, int rotateRight) {
        this.player = player;

        this.keyboard = false;
        this.mouseClick = true;

        this.rotateLeft = rotateLeft;
        this.rotateRight = rotateRight;
    }

    //keyboard
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!keyboard) return;
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
    //mouse
    @Override
    public void mouseClicked(MouseEvent e) {
        if (!mouseClick) return;
        System.out.println(e.getButton());
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
}
