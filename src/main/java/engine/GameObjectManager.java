package engine;

import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {
    protected List<GameObject> gameObjects = new ArrayList<>();
    protected List<GameObject> newGameObjects = new ArrayList<>();

    public void addGameObject(GameObject object){
        this.newGameObjects.add(object);
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }
    protected void update() {
        for (GameObject gameObject : gameObjects) {
            gameObject.update();
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }
}
