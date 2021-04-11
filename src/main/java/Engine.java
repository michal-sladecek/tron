import java.awt.*;
import java.util.ArrayList;

public class Engine extends Core{

    ArrayList<TronPlayer> players = new ArrayList<>();
    ArrayList<TronPlayerControl> controls  = new ArrayList<>();

    int moveAmount = 5;

    public void init() {
        super.init();

        Window w = sm.getFullScreenWindow();

        for (TronPlayerControl x: controls) {
            w.addKeyListener(x);
        }

        //w.addMouseListener(this);
        //w.addMouseMotionListener(this);
    }

    public void setPlayers(ArrayList<TronPlayer> players) {
        this.players = players;
    }

    public void setControls(ArrayList<TronPlayerControl> controls) {
        this.controls = controls;
    }

    @Override
    public void draw(Graphics2D g) {
        updateGameState();
        drawGameState(g);
    }

    private void drawGameState(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, sm.getWidth(), sm.getHeight());
        for (TronPlayer player: players) {
            drawPlayerPath(g,player.path,player.color);
        }
    }

    private void updateGameState() {
        movePlayers();
        checkForCollisions();
        updatePlayerPaths();
    }

    private void updatePlayerPaths() {
        for (TronPlayer player: players) {
            player.updatePath();
        }
    }

    private void movePlayers() {
        for (TronPlayer player: players) {
            player.movePlayer(moveAmount,sm.getWidth(), sm.getHeight());
        }
    }

    private void checkForCollisions() {
        for (TronPlayer player1: players) {
            for (TronPlayer player2: players) {
                if(player1.checkCollision(player2)){
                    System.exit(0);
                }
            }
        }
    }

    private void drawPlayerPath(Graphics2D g, ArrayList<Coordinates> playerPath, Color color) {
        for (int x = 0; x < playerPath.size(); x++) {
            g.setColor(color);
            g.fillRect(playerPath.get(x).getX(), playerPath.get(x).getY(), 10, 10);
        }
    }
}
