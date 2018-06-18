package github.com.PERS23.Boids;

public class Velocity {

    public int xMagnitude;
    public int yMagnitude;

    public Velocity(int xMagnitude, int yMagnitude) {
        this.xMagnitude = xMagnitude;
        this.yMagnitude = yMagnitude;
    }

    public Velocity(Velocity v) {
        this.xMagnitude = v.xMagnitude;
        this.yMagnitude = v.yMagnitude;
    }

    public void add(Velocity v) {
        xMagnitude += v.xMagnitude;
        yMagnitude += v.yMagnitude;
    }
}
