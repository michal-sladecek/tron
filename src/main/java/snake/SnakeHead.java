package snake;

import engine.Coordinates;
import engine.Direction;

import java.awt.*;

public class SnakeHead extends SnakeSegment {

    Direction direction;

    public SnakeHead(Coordinates location, Color color) {
        super(location, color);
    }

    @Override
    public void update() {

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


}
