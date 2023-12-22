import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SnakeGame extends JPanel {
    int boardWidth;
    int boardHeight;
    int tileSize = 25;

    SnakeHead snakeHead;
    Food food;

    public SnakeGame(int boardWidth,int boardHeight) {
        this.boardHeight=boardHeight;
        this.boardWidth=boardWidth;

        setPreferredSize(new Dimension(this.boardWidth,boardHeight));
        setBackground(Color.BLACK);

        snakeHead= new SnakeHead(5,5);
        food = new Food(10,10);
        food.placeFood(boardWidth/tileSize,boardHeight/tileSize);

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {
        //Grid
        for(int i = 0 ;i<boardWidth/tileSize;i++) {
            g.drawLine(i*tileSize,0,i*tileSize,boardHeight);
            g.drawLine(0,i*tileSize,boardWidth,i*tileSize);
        }

        //food
        g.setColor(Color.red);
        g.fillRect(food.getX()*tileSize,food.getY()*tileSize,tileSize,tileSize);

        //snakeHead
        g.setColor(Color.GREEN);
        g.fillRect(snakeHead.getX()*tileSize,snakeHead.getY()*tileSize,tileSize,tileSize);
    }


}
