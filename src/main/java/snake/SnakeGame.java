package snake;

import engine.Coordinates;
import engine.Core;
import engine.Direction;
import tron.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class SnakeGame extends Core {
    public SnakeGame() {
        super();
        this.collisionManager = new SnakeCollisionManager();
        this.presentation = new SnakePresentation(this);
        SnakeHead p1 = new SnakeHead(new Coordinates(40,40), Direction.RIGHT, Color.green,this);

        gameObjectManager.addGameObject(p1);

        presentation.addGameControl(new SnakeController(p1, KeyEvent.VK_UP,KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT));
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();
        game.run();
    }
}
