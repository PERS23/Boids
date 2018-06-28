package github.com.PERS23.Boids;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Environment {
    private final double vlim = 3.0;

    private List<MovementRule> mRules = new ArrayList<>();

    private List<Body> mBodies = new ArrayList<>();
    private List<Boid> mBoids = new ArrayList<>();
    private Double mContainerHeight;
    private Double mContainerWidth;

    public Environment() {
        mRules.add(new Centering());
        mRules.add(new Distancing());
        mRules.add(new Matching());
    }

    public void update() {
        for (Boid b : mBoids) {

            for (MovementRule rule : mRules) {
                Velocity2D newVelocity = rule.calculate(mBodies, mBoids, b);               // Calculate the new velocity
                b.addVelocity(newVelocity);                                                     // Add it to the current
            }
            bound(b);
            limitVelocity(b);
            b.update();                                               // Update the position with a tick of the velocity
        }
    }

    private void bound(Boid b) {
        double x = b.getVelocity().dx, y = b.getVelocity().dy;

        if (b.getX() < 40) {
            x = vlim;
        } else if (b.getX() > mContainerWidth - 40) {
            x = -1.0 * vlim;
        }

        if (b.getY() < 40) {
            y = vlim;
        } else if (b.getY() > mContainerHeight - 40) {
            y = -1.0 * vlim;
        }

        b.getVelocity().setSpeed(x, y);
    }

    private void limitVelocity(Boid b) {
        if (Math.abs(b.mVelocity.dx) > vlim) {
            b.getVelocity().dx = (b.getVelocity().dx / Math.abs(b.mVelocity.dx)) * vlim;
        }
        if (Math.abs(b.mVelocity.dy) > vlim) {
            b.getVelocity().dy = (b.getVelocity().dy / Math.abs(b.mVelocity.dy)) * vlim;
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
    }

    public void setContainerHeight(Double containerHeight) {
        mContainerHeight = containerHeight;
    }

    public void setContainerWidth(Double containerWidth) {
        mContainerWidth = containerWidth;
    }
}
