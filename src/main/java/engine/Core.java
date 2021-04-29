package engine;

public abstract class Core {

	protected CollisionManager collisionManager;
	protected GameObjectManager gameObjectManager = new GameObjectManager();

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

	public void init(){
		running = true;
	}
	
	public void gameLoop(){

		while (running){
			gameObjectManager.update();
			collisionManager.checkForCollisions(gameObjectManager.getGameObjects());
			presentation.updatePresentation();
			try{
				Thread.sleep(20);
			}catch(Exception ex){}
		}
	}

	public GameObjectManager getGameState() {
		return gameObjectManager;
	}
	public int getGameWidth(){
		return presentation.getScreenWidth();
	}

	public int getGameHeight(){
		return presentation.getScreenHeight();
	}
}
