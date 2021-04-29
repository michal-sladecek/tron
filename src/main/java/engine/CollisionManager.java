package engine;

import java.util.List;

public abstract class CollisionManager {
    public void checkForCollisions(List<GameObject> gameObjects) {
        for (GameObject o1: gameObjects) {
            for (GameObject o2: gameObjects) {
                if(o1 != o2 && checkCollision(o1, o2)){
                    handleCollision(o1, o2);

                }
            }
        }
    }
    public boolean checkCollision(GameObject gameObject1, GameObject gameObject2) {
        return gameObject1.getLocation().equals(gameObject2.getLocation());
    }

    public abstract void handleCollision(GameObject gameObject1, GameObject gameObject2);
}
