package kulkov.JavaCore;

import java.util.Random;

public class Human {
    private final int MIN_HIGH_LIMIT = 50;                          // ..все могут прыгнуть на 50 см, как минимум.
    private final int MAX_HIGH_LIMIT = 150;                         // предел высоты прыжка
    private final int MAX_DIST_LIMIT = 20000;                       // условный предел по бегу - 200 м

    private int highLimit;
    private int distanceLimit;
    private boolean flagForWalls = true;
    private boolean flagForRunTracks = true;

    public int getHighLimit() {
        return highLimit;
    }

    public int getDistanceLimit() {
        return distanceLimit;
    }

    public void setHighLimit(int highLimit) {
        this.highLimit = highLimit;
    }

    public void setDistanceLimit(int distanceLimit) {
        this.distanceLimit = distanceLimit;
    }

    // Constructor.
    public Human() {
        Random generator = new Random();
        this.highLimit = generator.nextInt((MAX_HIGH_LIMIT - MIN_HIGH_LIMIT)) + MIN_HIGH_LIMIT;     // В см.
        this.distanceLimit  = generator.nextInt(MAX_DIST_LIMIT);                                    // В см.
    }

    // Methods.
    public boolean jump(Wall wall)   {
        boolean result;
        if(this.flagForWalls && (this.highLimit >= wall.getHighWall()))  {
            result = true;
        } else {
            this.flagForWalls = false;
            result = false;
        }
        return result;
    }
}
