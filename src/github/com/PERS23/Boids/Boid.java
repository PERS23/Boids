package github.com.PERS23.Boids;

import javafx.scene.shape.Polygon;

public class Boid extends Body {
    public Boid(Coordinate2D position) {
        super(position);
        mAppearance = new Polygon();
    }
}
