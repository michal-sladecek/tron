package snake;

import engine.GamePresentation;

import java.awt.*;

public class SnakePresentation extends GamePresentation {

    private SnakeGame game;

    public SnakePresentation(SnakeGame game) {
        super();
        this.game = game;
    }

    @Override
    public void draw() {
        this.drawTemplate(game.getGameState().getGameObjects(), Color.BLACK);
    }
}
