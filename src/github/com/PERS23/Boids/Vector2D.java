package github.com.PERS23.Boids;

public class Vector2D {
    public double dx;
    public double dy;

    public Vector2D() {
        this(0.0, 0.0);
    }

    public Vector2D(Vector2D v) {
        this(v.dx, v.dy);
    }

    public Vector2D(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void setSpeed(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void addVelocity(Vector2D v) {
        addVelocity(v.dx, v.dy);
    }

    public void addVelocity(double dx, double dy) {
        this.dx += dx;
        this.dy += dy;
    }

    public double difference(Vector2D v) {
        return difference(v.dx, v.dy);
    }

    public double difference(double dx, double dy) {
        double x = this.dx - dx;
        double y = this.dy - dy;
        return Math.sqrt((x * x) + (y * y));
    }

    // http://www.mathstips.com/wp-content/uploads/2014/03/unit-circle.png
    public double angleOf() {                                                // Remember quadrants run counter clockwise
        if (dx == 0) {                                                                                     // Edge cases
            return (dy > 0) ? 90 : (dy == 0) ? 0 : 270;            // x is 0 so angle is 90 or 270 (0 if y is 0 as well)
        } else if (dy == 0) {
            return (dx >= 0) ? 0 : 180;         // y is 0 so the angle is either 0 or 180, y=0 & x=0 was already covered
        }

        double ret = Math.toDegrees(Math.atan(dy / dx));

        if (dx < 0 && dy < 0) {         // III Quadrant, angle is +ve so we need to add 180 to wrap it around to the III
            ret += 180;
        } else if (dx < 0) {   // II Quadrant, angle is -ve so we can sub it from 180 to get where it should actually be
            ret += 180;                                                                            // Actually subtracts
        } else if (dy < 0) {               // IV Quadrant, +90 to correct it and +270 to translate it to the IV Quadrant
            ret = 270 + (90 + ret);                                                                // Actually subtracts
        }

        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2D that = (Vector2D) o;
        return Double.compare(that.dx, dx) == 0 && Double.compare(that.dy, dy) == 0;
    }

    @Override
    public String toString() {
        return "Vector2D{" + "dx=" + dx + ", dy=" + dy + '}';
    }
}
