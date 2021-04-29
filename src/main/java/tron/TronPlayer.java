package tron;

import engine.*;

import java.awt.*;
import java.util.ArrayList;

public class TronPlayer extends MovableGameObject {
    public static int MOVE_AMOUNT = 5;

    public TronPlayer(Coordinates location, Direction direction, Color color, TronGame core) {
        super(location, color, core);
        this.direction = direction;
    }

    @Override
    public void update() {
        this.core.getGameState().addGameObject(new TronPlayerPathBlock(new Coordinates(location),color));
        moveObjectInDirection(MOVE_AMOUNT);
        correctOutOfBounds();
    }
}
