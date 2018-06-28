package github.com.PERS23.Boids;

import java.util.Objects;

public class Velocity2D {
    public double dx;
    public double dy;

    public Velocity2D() {
        this(0.0, 0.0);
    }

    public Velocity2D(Velocity2D v) {
        this(v.dx, v.dy);
    }

    public Velocity2D(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void setSpeed(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void addVelocity(Velocity2D v) {
        addVelocity(v.dx, v.dy);
    }

    public void addVelocity(double dx, double dy) {
        this.dx += dx;
        this.dy += dy;
    }

    public double difference(Velocity2D v) {
        return difference(v.dx, v.dy);
    }

    public double difference(double dx, double dy) {
        double x = this.dx - dx;
        double y = this.dy - dy;
        return Math.sqrt((x * x) + (y * y));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Velocity2D that = (Velocity2D) o;
        return Double.compare(that.dx, dx) == 0 && Double.compare(that.dy, dy) == 0;
    }

    @Override
    public String toString() {
        return "Velocity2D{" + "dx=" + dx + ", dy=" + dy + '}';
    }
}
