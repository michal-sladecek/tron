package tron;

import engine.Coordinates;
import engine.Core;
import engine.GameControl;
import engine.GameObject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TronGame extends Core {

    public TronGame() {
        ArrayList<GameObject> players = new ArrayList<>();
        ArrayList<GameControl> controls  = new ArrayList<>();

        TronPlayer p1 = new TronPlayer(new Coordinates(40,40), TronPlayer.Direction.RIGHT, Color.green,this);
        TronPlayer p2 = new TronPlayer(new Coordinates(600,440), TronPlayer.Direction.LEFT, Color.red,this);
        TronPlayer p3 = new TronPlayer(new Coordinates(900,500), TronPlayer.Direction.UP, Color.yellow,this);


        addGameObject(p1);
        addGameObject(p2);
        addGameObject(p3);

        addGameControl(new TronPlayerControl(p1, KeyEvent.VK_UP,KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT));
        addGameControl(new TronPlayerControl(p2, KeyEvent.VK_W,KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_A));
        addGameControl(new TronPlayerControl(p3, MouseEvent.BUTTON1, MouseEvent.BUTTON3));
    }

    @Override
    public void draw(Graphics2D g) {
        update();
        checkForCollisions();
        drawGameState(g);
    }

    private void drawGameState(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, sm.getWidth(), sm.getHeight());

        for (GameObject gameObject: gameObjects) {
            g.setColor(gameObject.getColor());
            g.fillRect(gameObject.getLocation().getX(),gameObject.getLocation().getY(),10,10);
        }
    }

    public static void main(String[] args) {
        TronGame y = new TronGame();
        y.run();
    }
}
