package github.com.PERS23.Boids;

import java.awt.geom.Point2D;
import java.util.List;

public class Centering implements MovementRule {
    private final double SCALING_FACTOR = 800.0;

    @Override
    public Vector2D calculate(List<Body> bodies, List<Boid> flock, Boid individual) {
        Point2D.Double center = new Point2D.Double();

        for (int i = 0; i < flock.size(); i++) {
            Boid b = flock.get(i);
            if (b != individual) {                                                       // Don't include the individual
                center.x += b.getX();
                center.y += b.getY();                                                        // Simply sum all positions
            }
        }

        if (flock.size() > 1) {    // Return velocity that will have mag equal to 0.00125% of the distance to the center
            double x = (center.x / (flock.size() - 1) - individual.getX()) / SCALING_FACTOR;
            double y = (center.y / (flock.size() - 1) - individual.getY()) / SCALING_FACTOR;
            return new Vector2D(x, y);
        }

        return new Vector2D(center.x, center.y);
    }
}
