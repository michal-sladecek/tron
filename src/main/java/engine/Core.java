package engine;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Core {
	protected ArrayList<GameObject> gameObjects = new ArrayList<>();
	protected ArrayList<GameObject> newGameObjects = new ArrayList<>();

	private boolean running;
	protected GamePresentation presentation;

	public void stop(){
		running = false;
	}
	
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
		long startTime = System.currentTimeMillis();
		long cumTime = startTime;
		
		while (running){
			long timePassed = System.currentTimeMillis()-cumTime;
			cumTime+= timePassed;
			update(timePassed);
			update();
			checkForCollisions();
			presentation.updatePresentation();
			try{
				Thread.sleep(20);
			}catch(Exception ex){}
		}
	}
	
	public void update(long timePassed){}



	public void addGameObject(GameObject object){
		this.newGameObjects.add(object);
	}

	public void addGameControl(GameControl control){
		presentation.getWindow().addKeyListener(control);
		presentation.getWindow().addMouseListener(control);
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
