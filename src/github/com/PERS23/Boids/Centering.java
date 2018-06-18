package github.com.PERS23.Boids;

import java.awt.*;
import java.util.List;

public class Centering implements BoidRule {

    @Override
    public Velocity calculate(List<Boid> flock, Boid individual) {
        Point center = new Point(flock.get(0).position);

        for (int i = 1; i < flock.size(); i++) {
            Boid b = flock.get(i);
            if (b != individual) {                                                       // Don't include the individual
                center.translate(b.position.x, b.position.y);                                // Simply sum all positions
            }
        }
                                                                     // N - 1 because we're not including the individual
        int xMagnitude = center.x / (flock.size() - 1), yMagnitude = center.y / (flock.size() - 1);
                                 // Return a velocity that will have magnitude equal to 1% of the distance to the center
        return new Velocity(xMagnitude / 100, yMagnitude / 100);
    }
}
