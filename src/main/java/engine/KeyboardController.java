package engine;

import java.awt.*;
import java.awt.event.KeyListener;

public abstract class KeyboardController implements KeyListener,GameControl {
    public void addSelf(Window window){
        window.addKeyListener(this);
    }
}
