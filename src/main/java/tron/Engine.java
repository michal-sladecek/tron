package tron;

import engine.Coordinates;
import engine.Core;
import engine.GameControl;
import engine.GameObject;

import java.awt.*;
import java.util.ArrayList;

public class Engine extends Core {


    @Override
    public void draw(Graphics2D g) {
        updateGameState();
        drawGameState(g);
    }

    private void drawGameState(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, sm.getWidth(), sm.getHeight());

        for (GameObject gameObject: gameObjects) {
            TronPlayer player = (TronPlayer) gameObject;
            drawPlayerPath(g,player.path,player.getColor());
        }
    }

    private void updateGameState() {
        update();
        checkForCollisions();
    }

    private void update() {
        for (GameObject gameObject : gameObjects) {
            gameObject.update();
            correctOutOfBounds(gameObject);
        }
    }



    public void correctOutOfBounds(GameObject gameObject) {
        Coordinates location = gameObject.getLocation();
        if (location.getY() < 0){
            location.setY(sm.getHeight());
        }
        if (location.getX() > sm.getWidth()){
            location.setX(0);
        }
        if (location.getY() > sm.getHeight()){
            location.setY(0);
        }
        if (location.getX() < 0){
            location.setX(sm.getWidth());
        }
    }

    private void checkForCollisions() {
        for (GameObject o1: gameObjects) {
            for (GameObject o2: gameObjects) {
                if(o1 != o2 && o1.checkCollision(o2)){
                    System.exit(0);
                }
            }
        }
    }

    private void drawPlayerPath(Graphics2D g, ArrayList<Coordinates> playerPath, Color color) {
        for (Coordinates coordinates : playerPath) {
            g.setColor(color);
            g.fillRect(coordinates.getX(), coordinates.getY(), 10, 10);
        }
    }
}
