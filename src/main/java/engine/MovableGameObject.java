package engine;

import java.awt.*;

public abstract class MovableGameObject extends GameObject {

    protected Core core;
    protected Direction direction;

    public MovableGameObject(Coordinates location, Color color, Core core) {
        super(location, color);
        this.core = core;
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

    private void move(int dx, int dy){
        this.location = new Coordinates(location.getX()+dx,location.getY()+dy);
    }

    public void moveObjectInDirection(int moveAmount) {
        switch(direction){
            case UP:
                move(0,-moveAmount);
                break;
            case RIGHT:
                move(moveAmount,0);
                break;
            case DOWN:
                move(0,moveAmount);
                break;
            case LEFT:
                move(-moveAmount,0);
                break;
        }
    }

    public void correctOutOfBounds() {
        if (location.getY() < 0){
            location.setY(core.getGameHeight());
        }
        if (location.getX() > core.getGameWidth()){
            location.setX(0);
        }
        if (location.getY() > core.getGameHeight()){
            location.setY(0);
        }
        if (location.getX() < 0){
            location.setX(core.getGameWidth());
        }
    }
}
