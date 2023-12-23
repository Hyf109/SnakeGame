import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {
    int boardWidth;
    int boardHeight;
    int tileSize = 25;

    SnakeHead snakeHead;
    SnakeBody snakeBody;
    Food food;
    //game logic
    Timer gameLoop;
    boolean gameOver = false;


    public SnakeGame(int boardWidth, int boardHeight) {
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;

        setPreferredSize(new Dimension(this.boardWidth, boardHeight));
        setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusable(true);

        snakeHead = new SnakeHead(5, 5);
        snakeBody = new SnakeBody();
        food = new Food(10, 10);
        food.placeFood(boardWidth / tileSize, boardHeight / tileSize);

        gameLoop = new Timer(100, this);
        gameLoop.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        //Grid
//        for (int i = 0; i < boardWidth / tileSize; i++) {
//            g.drawLine(i * tileSize, 0, i * tileSize, boardHeight);
//            g.drawLine(0, i * tileSize, boardWidth, i * tileSize);
//        }

        //food
        g.setColor(Color.red);
        g.fill3DRect(food.getX() * tileSize, food.getY() * tileSize, tileSize, tileSize,true);

        //snakeHead
        g.setColor(Color.GREEN);
        g.fill3DRect(snakeHead.getX() * tileSize, snakeHead.getY() * tileSize, tileSize, tileSize,true);
        //snakeBody
        for (int i = 0; i < snakeBody.getBody().size(); i++) {
            Tile snakePart = snakeBody.getBody().get(i);
            g.fill3DRect(snakePart.getX() * tileSize,
                    snakePart.getY() * tileSize,
                    tileSize, tileSize,true);
        }
        //Score
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        if (gameOver) {
            g.setColor(Color.red);
            g.drawString("Game over: " +
                    String.valueOf(snakeBody.getBody().size()), tileSize - 16, tileSize);
        }
        else {
            g.drawString("Score: " + String.valueOf(snakeBody.getBody().size()),
                    tileSize-16,tileSize);
        }
    }

//    public void move() {
//        //snake Head
//        snakeHead.setX(snakeHead.getX()+velocityX);
//        snakeHead.setY(snakeHead.getY()+velocityY);
//
//
//    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (snakeHead.moveHead(food, snakeBody.getBody(),
                boardWidth / tileSize, boardHeight / tileSize
        )) {
            System.out.println("Game over");
            gameOver = true;
            gameLoop.stop();
        }

        repaint();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP: {
                snakeHead.getMove().moveUp();
                break;
            }
            case KeyEvent.VK_DOWN: {
                snakeHead.getMove().moveDown();
                break;
            }
            case KeyEvent.VK_LEFT: {
                snakeHead.getMove().moveLeft();
                break;
            }
            case KeyEvent.VK_RIGHT: {
                snakeHead.getMove().moveRight();
                break;
            }
        }
    }

    //do not need
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
