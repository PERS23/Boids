package github.com.PERS23.Boids;

import java.util.List;

public interface MovementRule {
    Coordinate2D calculate(List<Body> bodies, List<Boid> flock, Boid individual);
}
