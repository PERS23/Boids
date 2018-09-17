package PERS23.Boids;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

public class Boid extends Body {
    private final Paint FILL = Paint.valueOf("#F38630");

    public Boid(double x, double y) {
        super(x, y, new Polygon(0.0, 25.0, 10.0, 0.0, 20.0, 25.0, 10.0, 20.0));
        mAppearance.setFill(FILL);
    }
}
