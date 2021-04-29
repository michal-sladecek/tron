package snake;

import engine.Coordinates;
import engine.GameObject;

import java.awt.*;

public class SnakeBodyBlock extends GameObject {
    public SnakeBodyBlock(Coordinates location, Color color) {
        super(location, color);
    }

    @Override
    public void update() {}
}
