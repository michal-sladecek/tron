import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TronPlayerControl implements KeyListener {
    int up,down,right,left;
    TronPlayer player;

    public TronPlayerControl(TronPlayer player, int up, int down, int right, int left) {
        this.player = player;
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
    }


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
