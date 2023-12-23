import java.util.List;

public class SnakeHead extends Tile{
    public Move move;
    public SnakeHead(int x, int y) {
        super(x,y);
        move = new Move();
    }
    public boolean moveHead(Food food, List<Tile> body, int sizeX,int sizeY) {
        //eat food
        if(collision(this,food)) {
            body.add(new Tile(food.getX(), food.getY()));
            food.placeFood(sizeX,sizeY);
        }

        //snake body
        for(int i = body.size()-1;i>=0;i--) {
            Tile snakePart = body.get(i);
            if(i == 0) {
                snakePart.setX(this.getX());
                snakePart.setY(this.getY());
            }
            else {
                Tile prevSnakePart = body.get(i-1);
                snakePart.setX(prevSnakePart.getX());
                snakePart.setY(prevSnakePart.getY());
            }

        }

        //moveHead
        super.setX(super.getX()+move.getVelocityX());
        super.setY(super.getY()+move.getVelocityY());

        //game over conditions
        for(int i = 0; i<body.size();i++) {
            Tile snakePart = body.get(i);
            //collide with the snake head
            if(collision(this,snakePart)) {
                return true;
            }
        }
        if(this.getX()<0 || this.getX()>sizeX ||
        this.getY()<0||this.getY()>sizeY) {
            return true;
        }
        return false;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}
