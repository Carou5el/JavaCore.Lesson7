package kulkov.JavaCore;

import java.util.Random;

public class RunTrack extends Barrier{
    private final int MIN_RUN_LENGTH = 1000;                // Дорожка от 10 м.
    private final int MAX_RUN_LENGTH = 15000;               // Дорожка до 150 м.

    private int runLength;

    public void setRunLength(int runLength) {
        this.runLength = runLength;
    }

    public int getRunLength() {
        return runLength;
    }

    // Constructor.
    public RunTrack() {
        Random generator = new Random();
        this.runLength = generator.nextInt((this.MAX_RUN_LENGTH - this.MIN_RUN_LENGTH)) + this.MIN_RUN_LENGTH;
    }
}
