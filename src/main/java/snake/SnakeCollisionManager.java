package snake;
import java.util.concurrent.ThreadLocalRandom;

import engine.CollisionManager;
import engine.Coordinates;
import engine.GameObject;

public class SnakeCollisionManager extends CollisionManager {
    public SnakeCollisionManager(int playgroundWidth, int playgroundHeight) {
        super(playgroundWidth, playgroundHeight);
    }
    //not sure about this
    @Override
    public void handleCollision(GameObject gameObject1, GameObject gameObject2) {
        System.out.println(gameObject1.getClass() + " " + gameObject2.getClass());
        if (gameObject1 instanceof SnakeHead && gameObject2 instanceof Apple) {
            ((SnakeHead) gameObject1).grow();
            //rounded to 10, so it can be hit by snake
            int randomX = ThreadLocalRandom.current().nextInt(0, this.playgroundWidth  / SnakeHead.MOVE_AMOUNT + 1) * SnakeHead.MOVE_AMOUNT;
            int randomY = ThreadLocalRandom.current().nextInt(0, this.playgroundHeight / SnakeHead.MOVE_AMOUNT + 1) * SnakeHead.MOVE_AMOUNT;
            gameObject2.getLocation().setX(randomX);
            gameObject2.getLocation().setY(randomY);
        } else if (!(gameObject1 instanceof Apple ||gameObject2 instanceof Apple)) {
            System.exit(0);
        }
    }
}
