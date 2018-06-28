package github.com.PERS23.Boids;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

public class Distancing implements MovementRule {
    @Override
    public Velocity2D calculate(List<Body> bodies, List<Boid> flock, Boid individual) {
        /* We initialise the base to zero as we want this rule to give us a vector which when added to the current
         * position moves the individual away from anything near it. */
        Velocity2D fleeVelocity = new Velocity2D(0.0, 0.0);

        for (Body b : bodies) {                                   // Considering all bodies in the scene, not just boids
            if (b != individual && Math.abs(b.distanceFrom(individual)) < 40) {
                   // Give it magnitude equal to the distance between to obstacle and it (in the opposite direction ofc)
                fleeVelocity.dx = fleeVelocity.dx - (b.getX() - individual.getX());
                fleeVelocity.dy = fleeVelocity.dy - (b.getY() - individual.getY());
            }
        }

        return fleeVelocity;
    }
}
