package tron;

import engine.Coordinates;
import engine.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TronPlayer extends GameObject {
    ArrayList<Coordinates> path = new ArrayList<>();
    protected TronPlayer.Direction direction;

    public TronPlayer(Coordinates location, Direction direction, Color color) {
        super(location, color);
        this.direction = direction;
    }

    public void move() {
        movePlayer(TronConstants.MOVE_AMOUNT);
    }

    public void movePlayer(int moveAmount) {
        switch(direction){
            case UP:
                location.move(0,-moveAmount);
                break;
            case RIGHT:
                location.move(moveAmount,0);
                break;
            case DOWN:
                location.move(0,moveAmount);
                break;
            case LEFT:
                location.move(-moveAmount,0);
                break;
        }
    }

    public boolean checkCollision(GameObject other){
        for (Coordinates coordinates : path) {
            if (other.getLocation().equals(coordinates)) {
                return true;
            }
        }
        return false;
    }

    public void updatePath(){
        path.add(new Coordinates(location));
    }

    public void setDirectionUP(){
        if(this.direction != Direction.DOWN)
            this.direction = Direction.UP;
    }
    public void setDirectionDOWN(){
        if(this.direction != Direction.UP)
            this.direction = Direction.DOWN;
    }
    public void setDirectionRIGHT(){
        if(this.direction != Direction.LEFT)
            this.direction = Direction.RIGHT;
    }
    public void setDirectionLEFT(){
        if(this.direction != Direction.RIGHT)
            this.direction = Direction.LEFT;
    }
    public void rotateRight() {
        this.direction = Direction.valueOf((this.direction.getValue() + 1) % 4);
    }
    public void rotateLeft() {
        if (direction.getValue() == 0) {
            direction = Direction.valueOf(3);
        } else {
            this.direction = Direction.valueOf((this.direction.getValue() - 1) % 4);
        }
    }
    @Override
    public void update() {
        updatePath();
    }
    public enum Direction {
        UP(0),
        RIGHT(1),
        DOWN(2),
        LEFT(3);

        private int value;
        private static Map<Integer, Direction> map = new HashMap<>();

        Direction(int value) {
            this.value = value;
        }

        static {
            for (Direction direction : Direction.values()) {
                map.put(direction.value, direction);
            }
        }

        public static Direction valueOf(int direction) {
            return map.get(direction);
        }

        public int getValue() {
            return value;
        }
    }
}