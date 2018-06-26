package github.com.PERS23.Boids;

import java.awt.*;
import java.util.List;

public class Centering implements MovementRule {
    @Override
    public Coordinate2D calculate(List<Body> bodies, List<Boid> flock, Boid individual) {
        Coordinate2D center = new Coordinate2D(flock.get(0).getPosition());

        for (int i = 1; i < flock.size(); i++) {
            Boid b = flock.get(i);
            if (b != individual) {                                                       // Don't include the individual
                center.translate(b.getPosition().x, b.getPosition().y);                      // Simply sum all positions
            }
        }
                                                                     // N - 1 because we're not including the individual
        double x = center.x / (flock.size() - 1), y = center.y / (flock.size() - 1);
                                 // Return a velocity that will have magnitude equal to 1% of the distance to the center
        return new Coordinate2D(x / 100, y / 100);
    }
}
