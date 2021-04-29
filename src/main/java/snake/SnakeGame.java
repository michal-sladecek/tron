package snake;

import engine.Coordinates;
import engine.Core;
import engine.Direction;
import tron.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.concurrent.ThreadLocalRandom;

public class SnakeGame extends Core {
    public SnakeGame() {
        super();
        this.presentation = new SnakePresentation(this);
        this.collisionManager = new SnakeCollisionManager(this.getGameWidth(), this.getGameHeight());

        SnakeHead p1 = new SnakeHead(new Coordinates(40,40), Direction.RIGHT, Color.green,this);

        gameObjectManager.addGameObject(p1);
        generateApples();


        presentation.addGameControl(new SnakeController(p1, KeyEvent.VK_UP,KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT));
    }

    private void generateApples() {
        for (int i = 0; i < 100; i++) {
            int randomX = ThreadLocalRandom.current().nextInt(0, this.getGameWidth()  / SnakeHead.MOVE_AMOUNT + 1) * SnakeHead.MOVE_AMOUNT;
            int randomY = ThreadLocalRandom.current().nextInt(0, this.getGameHeight() / SnakeHead.MOVE_AMOUNT + 1) * SnakeHead.MOVE_AMOUNT;
            Apple apple1 = new Apple(new Coordinates(randomX,randomY), Color.red);
            gameObjectManager.addGameObject(apple1);
        }
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();
        game.run();
    }
}
