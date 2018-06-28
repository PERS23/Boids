package github.com.PERS23.Boids;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

public class Centering implements MovementRule {
    @Override
    public Velocity2D calculate(List<Body> bodies, List<Boid> flock, Boid individual) {
        Point2D.Double center = new Point2D.Double();                               // Velocity acting as point

        for (int i = 0; i < flock.size(); i++) {
            Boid b = flock.get(i);
            if (b != individual) {                                                       // Don't include the individual
                center.x += b.getX();
                center.y += b.getY();                                                        // Simply sum all positions
            }
        }

        if (flock.size() > 1) { // Return velocity that will have magnitude equal to 0.01% of the distance to the center
            double x = (center.x / (flock.size() - 1) - individual.getX()) / 1000.0;
            double y = (center.y / (flock.size() - 1) - individual.getY()) / 1000.0;
            return new Velocity2D(x, y);
        }

        return new Velocity2D(center.x, center.y);
    }
}
