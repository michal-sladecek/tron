package engine;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class MouseController implements GameControl, MouseListener, MouseMotionListener {
    public void addSelf(Window window){
        window.addMouseListener(this);
        window.addMouseMotionListener(this);
    }
}
