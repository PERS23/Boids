package PERS23.Boids;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Environment {
    private final double V_LIM = 3.0;
    private final double BOUND_RADIUS = 40;

    private Double mContainerHeight;
    private Double mContainerWidth;
    private List<Body> mBodies = new ArrayList<>();
    private List<Boid> mBoids = new ArrayList<>();

    public void update() {
        for (Boid b : mBoids) {
            for (MovementRuleSet value : MovementRuleSet.values()) {
                Vector2D newVelocity = value.getRule().calculate(mBodies, mBoids, b);      // Calculate the new velocity
                b.addVelocity(newVelocity);                                                     // Add it to the current
            }
            bound(b);
            limitVelocity(b);
            b.update();                                               // Update the position with a tick of the velocity
        }
    }

    private void bound(Boid b) {
        double x = b.getVelocity().dx, y = b.getVelocity().dy;

        if (b.getX() <= BOUND_RADIUS) {   // If at or past the leftmost bound, turn it completely around as fast as poss
            x = V_LIM;
        } else if (b.getX() >= mContainerWidth - BOUND_RADIUS) {
            x = -1.0 * V_LIM;
        }

        if (b.getY() <= BOUND_RADIUS) {
            y = V_LIM;
        } else if (b.getY() >= mContainerHeight - BOUND_RADIUS) {
            y = -1.0 * V_LIM;
        }

        b.getVelocity().setSpeed(x, y);
    }

    private void limitVelocity(Boid b) {
        if (Math.abs(b.mVelocity.dx) > V_LIM) {
            b.getVelocity().dx = (b.getVelocity().dx / Math.abs(b.mVelocity.dx)) * V_LIM;
        }
        if (Math.abs(b.mVelocity.dy) > V_LIM) {
            b.getVelocity().dy = (b.getVelocity().dy / Math.abs(b.mVelocity.dy)) * V_LIM;
        }
    }

    public void addBoid(double x, double y, Pane container) {
        Boid b = new Boid(x, y);
        mBodies.add(b);
        mBoids.add(b);
        container.getChildren().add(b.getAppearance());
    }

    public void addObstacle(double x, double y, Pane container) {
        Obstacle o = new Obstacle(x, y);
        mBodies.add(o);
        container.getChildren().add(o.getAppearance());
    }

    public void setContainerHeight(Double containerHeight) {
        mContainerHeight = containerHeight;
    }

    public void setContainerWidth(Double containerWidth) {
        mContainerWidth = containerWidth;
    }
}
