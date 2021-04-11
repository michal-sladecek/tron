import java.awt.*;
import java.util.ArrayList;

public class TronPlayer extends GameObject{
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
            if (other.location.equals(coordinates)) {
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

    @Override
    public void update() {
        updatePath();
    }
    enum Direction{
        UP,
        RIGHT,
        DOWN,
        LEFT
    }
}
