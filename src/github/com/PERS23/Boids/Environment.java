package github.com.PERS23.Boids;

import java.util.ArrayList;
import java.util.List;

public class Environment {
    private List<Body> mBodies = new ArrayList<>();
    private List<Boid> mBoids = new ArrayList<>();

    public void update() {
         for (Boid b : mBoids) {
            for (MovementRules mr : MovementRules.values()) {
                Coordinate2D newVelocity = mr.getRule().calculate(mBodies, mBoids, b);     // Calculate the new velocity
                b.addVelocity(newVelocity);                                                     // Add it to the current
            }
            b.update();                                               // Update the position with a tick of the velocity
        }
    }

    public void addBoid(Coordinate2D point) {
        Boid b = new Boid(point);
        mBodies.add(b);
        mBoids.add(b);
    }

    public void addObstacle(Coordinate2D point) {
        Obstacle o = new Obstacle(point);
        mBodies.add(o);
    }
}
