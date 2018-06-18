package github.com.PERS23.Boids;

import java.util.List;

public class Distancing implements BoidRule {

    @Override
    public Velocity calculate(List<Boid> flock, Boid individual) {
        /* We initialise the base to zero as we want this rule to give us a vector which when added to the current
         * position moves a boid away from those near it. */
        Velocity fVelocity = new Velocity(0, 0);

        for (Boid b : flock) {
            if (b != individual && b.position.distance(individual.position) < 100) {
                   // Give it magnitude equal to the distance between to obstacle and it (in the opposite direction ofc)
                fVelocity.xMagnitude -= (b.position.x - individual.position.x);
                fVelocity.yMagnitude -= (b.position.y - individual.position.y);
            }
        }

        return fVelocity;
    }
}
