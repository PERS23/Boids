package PERS23.Boids;

import java.util.List;

public class Distancing implements MovementRule {
    private final double MIN_DIST = 40.0;
    private final double SCALING_FACTOR = 15.0;

    @Override
    public Vector2D calculate(List<Body> bodies, List<Boid> flock, Boid individual) {
        /* We initialise the base to zero as we want this rule to give us a vector which when added to the current
         * position moves the individual away from anything near it. */
        Vector2D fleeVelocity = new Vector2D(0.0, 0.0);

        for (Body b : bodies) {                                   // Considering all bodies in the scene, not just boids
            if (b != individual && Math.abs(b.distanceFrom(individual)) <= MIN_DIST) {
                   // Give it magnitude equal to the distance between to obstacle and it (in the opposite direction ofc)
                fleeVelocity.dx = (fleeVelocity.dx - (b.getX() - individual.getX())) / SCALING_FACTOR;
                fleeVelocity.dy = (fleeVelocity.dy - (b.getY() - individual.getY())) / SCALING_FACTOR;
            }
        }

        return fleeVelocity;
    }
}
