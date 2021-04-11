package tron;

import engine.Coordinates;
import engine.GameObject;

import java.awt.*;

public class TronPlayerPathBlock extends GameObject {

    public TronPlayerPathBlock(Coordinates location, Color color) {
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
