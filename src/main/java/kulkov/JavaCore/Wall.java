package kulkov.JavaCore;

import java.util.Random;

public class Wall extends Barrier{
    private final int MIN_WALLS_HIGH = 40;
    private final int MAX_WALLS_HIGH = 110;

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
        this.highWall = generator.nextInt((this.MAX_WALLS_HIGH - this.MIN_WALLS_HIGH)) + this.MIN_WALLS_HIGH;
    }
}
