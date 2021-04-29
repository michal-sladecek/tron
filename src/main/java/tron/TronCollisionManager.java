package tron;

import engine.CollisionManager;
import engine.GameObject;

public class TronCollisionManager extends CollisionManager {
    public TronCollisionManager(int playgroundWidth, int playgroundHeight) {
        super(playgroundWidth, playgroundHeight);
    }

    @Override
    public void handleCollision(GameObject gameObject1, GameObject gameObject2)
    {
        System.exit(0);
    }

}

