import java.util.ArrayList;

public class Player {
    Coordinates location;
    Direction direction;
    ArrayList<Coordinates> path = new ArrayList<Coordinates>();

    public Player(Coordinates location, Direction direction) {
        this.location = location;
        this.direction = direction;
    }

    public void movePlayer(int moveAmount, int gameWidth, int gameHeight) {
        switch(direction){
            case UP:
                if (location.getY()>0){
                    location.move(0,-moveAmount);
                } else {
                    location.setY(gameHeight);
                }
                break;
            case RIGHT:
                if (location.getX() < gameWidth){
                    location.move(moveAmount,0);
                } else {
                    location.setX(0);
                }
                break;
            case DOWN:
                if (location.getY() < gameHeight){
                    location.move(0,moveAmount);
                } else {
                    location.setY(0);
                }
                break;
            case LEFT:
                if (location.getX()>0){
                    location.move(-moveAmount,0);
                } else {
                    location.setX(gameWidth);
                }
                break;
        }
    }

    public boolean checkCollision(Player otherPlayer){
        for(int i=0;i<path.size();i++){
            if(otherPlayer.location.equals(path.get(i))){
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

    enum Direction{
        UP,
        RIGHT,
        DOWN,
        LEFT
    }
}
