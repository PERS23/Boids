package github.com.PERS23.Boids;

import java.util.List;

public interface BoidRule {

    public Velocity calculate(List<Boid> flock, Boid individual);
}
