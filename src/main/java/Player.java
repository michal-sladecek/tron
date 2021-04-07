import java.util.ArrayList;

public class Player {
    Coordinates location = new Coordinates(40,40);
    Direction direction = Direction.RIGHT;
    ArrayList<Coordinates> path = new ArrayList<Coordinates>();

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

    public void updatePath(){
        path.add(new Coordinates(location));
    }


    enum Direction{
        UP,
        RIGHT,
        DOWN,
        LEFT
    }


}
