import java.util.ArrayList;

public class Player {
    Coordinates location = new Coordinates(40,40);
    Direction direction = Direction.RIGHT;
    ArrayList<Coordinates> path = new ArrayList<Coordinates>();

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
