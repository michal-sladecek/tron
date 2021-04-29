package engine;

import java.util.ArrayList;
import java.util.List;

public abstract class Core {
	protected List<GameObject> gameObjects = new ArrayList<>();
	protected List<GameObject> newGameObjects = new ArrayList<>();
	private CollisionManager collisionManager = new CollisionManager();

	private boolean running;
	protected GamePresentation presentation;

	public void run(){
		try{
			init();
			gameLoop();
		}finally{
			presentation.restore();
		}
	}

	public List<GameObject> getGameObjects() {
		return gameObjects;
	}

	public void init(){
		running = true;
	}
	
	public void gameLoop(){

		while (running){
			update();
			collisionManager.checkForCollisions(gameObjects);
			presentation.updatePresentation();
			try{
				Thread.sleep(20);
			}catch(Exception ex){}
		}
	}
	

	public void addGameObject(GameObject object){
		this.newGameObjects.add(object);
	}

	protected void update() {
		for (GameObject gameObject : gameObjects) {
			gameObject.update();
		}
		gameObjects.addAll(newGameObjects);
		newGameObjects.clear();
	}



	public int getGameWidth(){
		return presentation.getScreenWidth();
	}

	public int getGameHeight(){
		return presentation.getScreenHeight();
	}
}
