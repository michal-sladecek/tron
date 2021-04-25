package tron;

import engine.*;

import java.awt.*;
import java.util.ArrayList;

public class TronPlayer extends MovableGameObject {
    public static int MOVE_AMOUNT = 5;
    ArrayList<Coordinates> path = new ArrayList<>();

    private Core game;

    public TronPlayer(Coordinates location, Direction direction, Color color, Core engine) {
        super(location, color);
        this.direction = direction;
        this.game = engine;
    }

    private void move(int dx, int dy){
        this.location = new Coordinates(location.getX()+dx,location.getY()+dy);
    }

    public void correctOutOfBounds() {
        if (location.getY() < 0){
            location.setY(game.getGameHeight());
        }
        if (location.getX() > game.getGameWidth()){
            location.setX(0);
        }
        if (location.getY() > game.getGameHeight()){
            location.setY(0);
        }
        if (location.getX() < 0){
            location.setX(game.getGameWidth());
        }
    }

    public void movePlayer(int moveAmount) {
        switch(direction){
            case UP:
                move(0,-moveAmount);
                break;
            case RIGHT:
                move(moveAmount,0);
                break;
            case DOWN:
                move(0,moveAmount);
                break;
            case LEFT:
                move(-moveAmount,0);
                break;
        }
    }

    public boolean checkCollision(GameObject other){
        if (other.getLocation().equals(location)) {
            return true;
        }
        return false;
    }



    @Override
    public void update() {
        game.addGameObject(new TronPlayerPathBlock(new Coordinates(location),color));
        movePlayer(MOVE_AMOUNT);
        correctOutOfBounds();
    }

    @Override
    public void handleCollision(GameObject object) {
        System.exit(0);
    }

}
