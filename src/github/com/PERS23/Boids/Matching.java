package github.com.PERS23.Boids;

import java.util.List;

public class Matching implements MovementRule {
    private final double SCALING_FACTOR = 8.0;

    @Override
    public Vector2D calculate(List<Body> bodies, List<Boid> flock, Boid individual) {
        Vector2D pVelocity = new Vector2D(flock.get(0).getVelocity());

        for (int i = 1; i < flock.size(); i++) {
            Boid b = flock.get(i);
            if (b != individual) {
                pVelocity.addVelocity(b.getVelocity());                                         // Sum up the velocities
            }
        }

        if (flock.size() > 1) {
            pVelocity.dx /= flock.size() - 1;                                                // Average out the velocity
            pVelocity.dx = (pVelocity.dx - individual.getVelocity().dx) / SCALING_FACTOR;
                            // Set the velocity to be an eighth of the difference between the average and the individual
            pVelocity.dy /= flock.size() - 1;
            pVelocity.dy = (pVelocity.dy - individual.getVelocity().dy) / SCALING_FACTOR;
        }

        return pVelocity;
    }
}
