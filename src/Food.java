import java.util.Random;

public class Food extends Tile {

    public Food(int x, int y) {
        super(x,y);
    }

    public void placeFood(int sizeX, int sizeY) {
        Random random = new Random();
        super.setX(random.nextInt(sizeX));
        super.setY(random.nextInt(sizeY));
    }
}
