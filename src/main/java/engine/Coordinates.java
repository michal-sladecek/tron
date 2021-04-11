package engine;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates(Coordinates c) {
        this.x = c.x;
        this.y = c.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

    public boolean equals(Coordinates c) {
        return c.x == this.x && c.y == this.y;
    }


}
