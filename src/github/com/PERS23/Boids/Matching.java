package github.com.PERS23.Boids;

import java.util.List;

public class Matching implements BoidRule {

    @Override
    public Velocity calculate(List<Boid> flock, Boid individual) {
        Velocity pVelocity = new Velocity(flock.get(0).velocity);

        for (int i = 1; i < flock.size(); i++) {
            Boid b = flock.get(i);
            if (b != individual) {
                pVelocity.add(b.velocity);
            }
        }

        pVelocity.xMagnitude /= flock.size() - 1;                                            // Average out the velocity
        pVelocity.xMagnitude = (pVelocity.xMagnitude - individual.velocity.xMagnitude) / 8;

        pVelocity.yMagnitude /= flock.size() - 1;
        pVelocity.yMagnitude = (pVelocity.yMagnitude - individual.velocity.yMagnitude) / 8;
                            // Set the velocity to be an eighth of the difference between the average and the individual
        return pVelocity;
    }
}
