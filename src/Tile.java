public class Tile {
    private int x;
    private int y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public boolean collision(Tile tile1, Tile tile2) {
        return tile1.getX()==tile2.getX()
                && tile1.getY()==tile2.getY();
    }
}
