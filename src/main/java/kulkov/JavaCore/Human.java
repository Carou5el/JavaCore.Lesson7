package kulkov.JavaCore;

import java.util.Random;

public class Human{
    private final int MIN_HIGH_LIMIT = 50;                          // ..все могут прыгнуть на 50 см, как минимум.
    private final int MAX_HIGH_LIMIT = 150;                         // предел высоты прыжка
    private final int MIN_DIST_LIMIT = 1000;                        // ..все могут пробежать хотя бы 10 м
    private final int MAX_DIST_LIMIT = 30000;                       // условный предел по бегу - 300 м

    private int highLimit;
    private int distanceLimit;
    private boolean flagToGo = true;

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
        this.highLimit = generator.nextInt((MAX_HIGH_LIMIT - MIN_HIGH_LIMIT)) + MIN_HIGH_LIMIT;
        this.distanceLimit  = generator.nextInt((MAX_DIST_LIMIT - MIN_DIST_LIMIT)) + MIN_DIST_LIMIT;
    }

    // Methods.
    // Method for Walls.
    public boolean jump(Wall wall)   {
        boolean result;
        if(this.flagToGo && (this.highLimit >= wall.getHighWall()))  {
            result = true;
        } else {
            this.flagToGo = false;
            result = false;
        }
        return result;
    }
    // Method for RunTracks.
    public boolean run(RunTrack runTrack)   {
        boolean result;
        if(this.flagToGo && (this.distanceLimit >= runTrack.getRunLength()))  {
            result = true;
        } else {
            this.flagToGo = false;
            result = false;
        }
        return result;
    }
}
