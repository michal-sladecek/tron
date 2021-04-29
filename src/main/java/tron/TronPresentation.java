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
        this.drawTemplate(game.getGameObjects(), Color.BLACK);
    }
}
