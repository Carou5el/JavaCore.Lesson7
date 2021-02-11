package kulkov.JavaCore;

import java.util.Random;

public class Human {
    private int highLimit;
    private int distanceLimit;

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
        this.highLimit = generator.nextInt(150);            // В см.
        this.distanceLimit  = generator.nextInt(20000);     // В см.
    }

    // Methods.
    public boolean jump(Wall wall)   {
        return (this.highLimit >= wall.getHighWall());
    }
}
