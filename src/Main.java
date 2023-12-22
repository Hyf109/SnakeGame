import javax.swing.*;

public class Main {


    public static void main(String[] args) throws Exception{
        JFrame frame = new JFrame("Snake Game");

        final int boardWidth  =600;
        final int boardheight = 600;
        frame.setSize(boardWidth,boardheight);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakeGame snakeGame = new SnakeGame(boardWidth,boardheight);
        frame.add(snakeGame);
        frame.pack();
    }
}