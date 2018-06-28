package github.com.PERS23.Boids;

import javafx.scene.shape.Polygon;

public class Boid extends Body {

    public Boid(double x, double y) {
        super(x, y, new Polygon(0.0, 25.0, 10.0, 0.0, 20.0, 25.0, 10.0, 20.0));
    }
}
