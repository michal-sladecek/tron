package tron;

import engine.*;

import java.awt.*;
import java.util.ArrayList;

public class TronPlayer extends MovableGameObject {
    public static int MOVE_AMOUNT = 5;
    ArrayList<Coordinates> path = new ArrayList<>();

    public TronPlayer(Coordinates location, Direction direction, Color color, Core core) {
        super(location, color, core);
        this.direction = direction;
    }

    public boolean checkCollision(GameObject other){
        return other.getLocation().equals(location);
    }

    @Override
    public void update() {
        this.core.addGameObject(new TronPlayerPathBlock(new Coordinates(location),color));
        movePlayer(MOVE_AMOUNT);
        correctOutOfBounds();
    }

    @Override
    public void handleCollision(GameObject object) {
        System.exit(0);
    }

}
