package PERS23.Boids;

import javafx.scene.shape.Shape;

public abstract class Body {
    protected Shape mAppearance;
    protected Vector2D mVelocity;

    public Body(double x, double y, Shape appearance) {
        this(x, y, appearance, new Vector2D());
    }

    public Body(double x, double y, Shape appearance, Vector2D velocity) {
        mAppearance = appearance;
        mAppearance.setLayoutX(x);
        mAppearance.setLayoutY(y);
        mVelocity = velocity;
    }

    public double getX() {
        return mAppearance.getLayoutX();
    }

    public double getY() {
        return mAppearance.getLayoutY();
    }

    public Vector2D getVelocity() {
        return mVelocity;
    }

    public Shape getAppearance() {
        return mAppearance;
    }

    public void addVelocity(Vector2D v) {
        this.mVelocity.addVelocity(v);
    }

    public Double distanceFrom(Body other) {
        double a = other.getX() - this.getX();
        double b = other.getY() - this.getY();
        return Math.sqrt(a * a + b * b);
    }

    public void update() {
        mAppearance.setLayoutX(getX() + mVelocity.dx);
        mAppearance.setLayoutY(getY() + mVelocity.dy);
        mAppearance.setRotate(mVelocity.angleOf() + 90); // Adding 90 to offset the screen coords from regular ones
    }
}
