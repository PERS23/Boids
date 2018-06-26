package github.com.PERS23.Boids;

import java.awt.*;
import java.util.List;

public class Matching implements MovementRule {
    @Override
    public Coordinate2D calculate(List<Body> bodies, List<Boid> flock, Boid individual) {
        Coordinate2D pVelocity = new Coordinate2D(flock.get(0).getVelocity());

        for (int i = 1; i < flock.size(); i++) {
            Boid b = flock.get(i);
            if (b != individual) {
                pVelocity.translate(b.getVelocity().x, b.getVelocity().y);                                // Sum up the velocities
            }
        }

        pVelocity.x /= flock.size() - 1;                                                     // Average out the velocity
        pVelocity.x = (pVelocity.x - individual.getVelocity().x) / 8;
                            // Set the velocity to be an eighth of the difference between the average and the individual
        pVelocity.y /= flock.size() - 1;
        pVelocity.y = (pVelocity.y - individual.getVelocity().y) / 8;

        return pVelocity;
    }
}
