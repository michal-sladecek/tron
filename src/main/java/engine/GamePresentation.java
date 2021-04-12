package engine;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GamePresentation {
    private static final DisplayMode modes[] =
            {
                    //new DisplayMode(1920,1080,32,0),
                    new DisplayMode(1680,1050,32,0),
                    //new DisplayMode(1280,1024,32,0),
                    new DisplayMode(800,600,32,0),
                    new DisplayMode(800,600,24,0),
                    new DisplayMode(800,600,16,0),
                    new DisplayMode(640,480,32,0),
                    new DisplayMode(640,480,24,0),
                    new DisplayMode(640,480,16,0),
            };

    protected ScreenManager sm;
    public Window getWindow(){
        return sm.getFullScreenWindow();
    }

    public GamePresentation() {
        sm = new ScreenManager();
        DisplayMode dm = sm.findFirstCompatibaleMode(modes);
        sm.setFullScreen(dm);
        Window w = getWindow();
        w.setFont(new Font("Arial",Font.PLAIN,20));
        w.setBackground(Color.WHITE);
        w.setForeground(Color.RED);
        w.setCursor(w.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),"null"));
    }

    public void updatePresentation(){
        draw();
        sm.update();
    }

    public void restore(){
        sm.restoreScreen();
    }
    public int getScreenHeight(){
        return sm.getHeight();
    }
    public int getScreenWidth(){
        return sm.getWidth();
    }

    public abstract void draw();
}
