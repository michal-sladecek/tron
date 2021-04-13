package tron;

import engine.Coordinates;
import engine.Core;
import engine.Direction;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class TronGame extends Core {

    public TronGame() {
        super();
        this.presentation = new TronPresentation(this);
        TronPlayer p1 = new TronPlayer(new Coordinates(40,40), Direction.RIGHT, Color.green,this);
        TronPlayer p2 = new TronPlayer(new Coordinates(600,440), Direction.LEFT, Color.red,this);
        TronPlayer p3 = new TronPlayer(new Coordinates(900,500), Direction.UP, Color.yellow,this);


        addGameObject(p1);
        addGameObject(p2);
        addGameObject(p3);

        presentation.addGameControl(new TronPlayerKeyboardControl(p1, KeyEvent.VK_UP,KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT));
        presentation.addGameControl(new TronPlayerKeyboardControl(p2, KeyEvent.VK_W,KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_A));
        presentation.addGameControl(new TronPlayerMouseControl(p3, MouseEvent.BUTTON1, MouseEvent.BUTTON3));
    }




    public static void main(String[] args) {
        TronGame game = new TronGame();
        game.run();
    }
}
