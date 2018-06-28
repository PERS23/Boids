package github.com.PERS23.Boids;

import javafx.scene.shape.Circle;

public class Obstacle extends Body {
    public Obstacle(double x, double y) {
        super(x, y, new Circle(10));
    }
}
