package github.com.PERS23.Boids;

import javafx.scene.shape.Circle;

public class Obstacle extends Body {
    public Obstacle(Coordinate2D position) {
        super(position);
        mAppearance = new Circle(20);
    }
}
