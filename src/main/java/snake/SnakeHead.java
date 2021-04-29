package snake;

import engine.Coordinates;
import engine.Direction;
import engine.MovableGameObject;
import tron.TronGame;
import tron.TronPlayerPathBlock;

import java.awt.*;

public class SnakeHead extends MovableGameObject {
    public static int MOVE_AMOUNT = 5;

    public SnakeHead(Coordinates location, Direction direction, Color color, SnakeGame core) {
        super(location, color, core);
        this.direction = direction;
    }

    @Override
    public void update() {
        //this.core.getGameState().addGameObject(new TronPlayerPathBlock(new Coordinates(location),color));
        moveObjectInDirection(MOVE_AMOUNT);
        correctOutOfBounds();
    }
}
