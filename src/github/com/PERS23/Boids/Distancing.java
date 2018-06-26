package github.com.PERS23.Boids;

import java.awt.*;
import java.util.List;

public class Distancing implements MovementRule {
    @Override
    public Coordinate2D calculate(List<Body> bodies, List<Boid> flock, Boid individual) {
        /* We initialise the base to zero as we want this rule to give us a vector which when added to the current
         * position moves the individual away from anything near it. */
        Coordinate2D fleeVelocity = new Coordinate2D(0.0, 0.0);

        for (Body b : bodies) {                                   // Considering all bodies in the scene, not just boids
            if (b != individual && b.getPosition().distance(individual.getPosition()) < 100) {
                   // Give it magnitude equal to the distance between to obstacle and it (in the opposite direction ofc)
                fleeVelocity.x -= (b.getPosition().x - individual.getPosition().x);
                fleeVelocity.y -= (b.getPosition().y - individual.getPosition().y);
            }
        }

        return fleeVelocity;
    }
}
