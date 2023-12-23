public class Move {
    private int velocityX;
    private int velocityY;

    public Move() {
        velocityX = 0;
        velocityY = 0;

    }

    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public void moveUp() {
        if (this.velocityY != 1) {
            setVelocityX(0);
            setVelocityY(-1);
        }
    }

    public void moveDown() {
        if(this.velocityY!=-1)
        {
            setVelocityX(0);
            setVelocityY(1);
        }
    }

    public void moveLeft() {
        if(this.velocityX!=1) {
            setVelocityX(-1);
            setVelocityY(0);
        }
    }

    public void moveRight() {
        if(this.velocityX!=-1) {
            setVelocityX(1);
            setVelocityY(0);
        }
    }
}
