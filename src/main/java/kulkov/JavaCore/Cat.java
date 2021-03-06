package kulkov.JavaCore;

import java.util.Random;

public class Cat {


    private final int MIN_HIGH_LIMIT = 70;                          // ..все могут прыгнуть на 70 см, как минимум.
    private final int MAX_HIGH_LIMIT = 150;                         // предел высоты прыжка
    private final int MIN_DIST_LIMIT = 1000;                        // ..все могут пробежать хотя бы 10 м
    private final int MAX_DIST_LIMIT = 10000;                       // условный предел по бегу - 100 м

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
    public Cat() {
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
