package github.com.PERS23.Boids;

import java.awt.*;
import java.util.Objects;

public class Coordinate2D {
    public double x;
    public double y;

    public Coordinate2D() {
        this(0.0,0.0);
    }

    public Coordinate2D(Coordinate2D point) {
        this(point.x, point.y);
    }

    public Coordinate2D(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate2D getLocation() {
        return new Coordinate2D(x, y);
    }

    public void setLocation(Coordinate2D point) {
        move(point.x, point.y);
    }

    public void move(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public void translate(Double dx, Double dy) {
        this.x += dx;
        this.y += dy;
    }

    public double distance(Coordinate2D other) {
        double a = this.x - other.x;
        double b = this.y - other.y;
        return Math.sqrt((a * a) + (b * b));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Coordinate2D that = (Coordinate2D) o;

        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
    }

}
