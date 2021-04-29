package snake;

import engine.*;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class SnakeHead extends MovableGameObject {
    public static int MOVE_AMOUNT = 5;
    public List<SnakeBodyBlock> body = new LinkedList<>();

    public SnakeHead(Coordinates location, Direction direction, Color color, SnakeGame core) {
        super(location, color, core);
        this.direction = direction;
    }

    public void grow() {
        SnakeBodyBlock block = new SnakeBodyBlock(new Coordinates(location),color);
        body.add(block);
        System.out.println("grow " + body.size());
        this.core.getGameState().addGameObject(block);
    }
    @Override
    public void update() {
        updateBody();
        moveObjectInDirection(MOVE_AMOUNT);
        correctOutOfBounds();
    }

    private void updateBody() {
        for (int i = body.size() - 1; i > 0; i--) {
            body.get(i).setLocation(body.get(i-1).getLocation());
        }
        if (!body.isEmpty()) {
            body.get(0).setLocation(this.getLocation());
        }
    }
}

