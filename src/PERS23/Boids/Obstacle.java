package PERS23.Boids;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Obstacle extends Body {
    private final Paint FILL = Paint.valueOf("#E0E4CC");

    public Obstacle(double x, double y) {
        super(x, y, new Circle(10));
        mAppearance.setFill(FILL);
    }
}
