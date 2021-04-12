package snake;

import engine.Coordinates;
import engine.GameObject;

import java.awt.*;

public class Apple extends GameObject {


    public Apple(Coordinates location, Color color) {
        super(location, color);
    }

    @Override
    public boolean checkCollision(GameObject other) {
        return false;
    }

    @Override
    public void update() {

    }

    @Override
    public void handleCollision(GameObject object) {

    }
}
