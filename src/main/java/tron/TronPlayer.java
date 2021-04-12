package tron;

import engine.Coordinates;
import engine.Core;
import engine.Direction;
import engine.GameObject;

import java.awt.*;
import java.util.ArrayList;

public class TronPlayer extends GameObject {
    ArrayList<Coordinates> path = new ArrayList<>();
    protected Direction direction;
    private Core game;

    public TronPlayer(Coordinates location, Direction direction, Color color, Core engine) {
        super(location, color);
        this.direction = direction;
        this.game = engine;
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
                location.move(0,-moveAmount);
                break;
            case RIGHT:
                location.move(moveAmount,0);
                break;
            case DOWN:
                location.move(0,moveAmount);
                break;
            case LEFT:
                location.move(-moveAmount,0);
                break;
        }
    }

    public boolean checkCollision(GameObject other){
        if (other.getLocation().equals(location)) {
            return true;
        }
        return false;
    }

    public void setDirectionUP(){
        if(this.direction != Direction.DOWN)
            this.direction = Direction.UP;
    }
    public void setDirectionDOWN(){
        if(this.direction != Direction.UP)
            this.direction = Direction.DOWN;
    }
    public void setDirectionRIGHT(){
        if(this.direction != Direction.LEFT)
            this.direction = Direction.RIGHT;
    }
    public void setDirectionLEFT(){
        if(this.direction != Direction.RIGHT)
            this.direction = Direction.LEFT;
    }
    public void rotateRight() {
        this.direction = Direction.valueOf((this.direction.getValue() + 1) % 4);
    }
    public void rotateLeft() {
        if (direction.getValue() == 0) {
            direction = Direction.valueOf(3);
        } else {
            this.direction = Direction.valueOf((this.direction.getValue() - 1) % 4);
        }
    }

    @Override
    public void update() {
        game.addGameObject(new TronPlayerPathBlock(new Coordinates(location),color));
        movePlayer(TronConstants.MOVE_AMOUNT);
        correctOutOfBounds();
    }

    @Override
    public void handleCollision(GameObject object) {
        System.exit(0);
    }

}
