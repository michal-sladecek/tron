package engine;

import java.awt.*;

public abstract class MovableGameObject extends GameObject {

    protected Direction direction;

    public MovableGameObject(Coordinates location, Color color) {
        super(location, color);
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
}
