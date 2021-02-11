package kulkov.JavaCore;

import java.util.Random;

public class Wall {
    private int highWall;

    public void setHighWall(int highWall) {
        this.highWall = highWall;
    }

    public int getHighWall() {
        return highWall;
    }

    // Constructor.
    public Wall() {
        Random generator = new Random();
        this.highWall = generator.nextInt(150);
    }
}
