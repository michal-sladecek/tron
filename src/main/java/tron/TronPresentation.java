package tron;

import engine.GameObject;
import engine.GamePresentation;

import java.awt.*;

public class TronPresentation extends GamePresentation {

    private TronGame game;

    public TronPresentation(TronGame game) {
        super();
        this.game = game;
    }

    @Override
    public void draw() {
        Graphics2D g = sm.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, sm.getWidth(), sm.getHeight());

        for (GameObject gameObject: game.getGameObjects()) {
            g.setColor(gameObject.getColor());
            g.fillRect(gameObject.getLocation().getX(),gameObject.getLocation().getY(),10,10);
        }
    }
}
