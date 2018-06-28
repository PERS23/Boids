package github.com.PERS23.Boids;

import javafx.scene.shape.Shape;

import java.awt.*;


public abstract class Body {
    protected Shape mAppearance;
    protected Velocity2D mVelocity;

    public Body(double x, double y, Shape appearance) {
        this(x, y, appearance, new Velocity2D());
    }

    public Body(double x, double y, Shape appearance, Velocity2D velocity) {
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

    public Velocity2D getVelocity() {
        return mVelocity;
    }

    public Shape getAppearance() {
        return mAppearance;
    }

    public void addVelocity(Velocity2D v) {
        this.mVelocity.addVelocity(v);
    }

    public Double distanceFrom(Body other) {
        double a = other.getX() - this.getX();
        double b = other.getY() - this.getY();
        return Math.sqrt(a * a + b * b);
    }

    public void update() {
        mAppearance.setTranslateX(mVelocity.dx);
        mAppearance.setTranslateY(mVelocity.dy);

        mAppearance.setLayoutX(getX() + mAppearance.getTranslateX());
        mAppearance.setLayoutY(getY() + mAppearance.getTranslateY());

        double adjacent, opposite;

        if (Math.abs(mVelocity.dx) > Math.abs(mVelocity.dy)) {
            adjacent = mVelocity.dx;
            opposite = mVelocity.dy;
        } else {
            adjacent = mVelocity.dy;
            opposite = mVelocity.dx;
        }

        Double angle = Math.toDegrees(Math.atan(opposite/adjacent)) + 90;
        mAppearance.setRotate(angle);
    }
}
