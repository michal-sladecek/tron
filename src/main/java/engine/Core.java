package engine;

import java.util.ArrayList;

public abstract class Core {
	protected ArrayList<GameObject> gameObjects = new ArrayList<>();
	protected ArrayList<GameObject> newGameObjects = new ArrayList<>();

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

	public ArrayList<GameObject> getGameObjects() {
		return gameObjects;
	}

	public void init(){
		running = true;
	}
	
	public void gameLoop(){

		while (running){
			update();
			checkForCollisions();
			presentation.updatePresentation();
			try{
				Thread.sleep(20);
			}catch(Exception ex){}
		}
	}
	

	public void addGameObject(GameObject object){
		this.newGameObjects.add(object);
	}

	protected void checkForCollisions() {
		for (GameObject o1: gameObjects) {
			for (GameObject o2: gameObjects) {
				if(o1 != o2 && o1.checkCollision(o2)){
					o1.handleCollision(o2);

				}
			}
		}
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
