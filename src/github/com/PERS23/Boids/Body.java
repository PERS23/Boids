package github.com.PERS23.Boids;

import javafx.scene.shape.Shape;


public abstract class Body {
    protected Shape mAppearance;
    private Coordinate2D mPosition;
    private Coordinate2D mVelocity;

    public Body(Coordinate2D position) {
        this(position, new Coordinate2D());
    }

    public Body(Coordinate2D position, Coordinate2D velocity) {
        this.mPosition = position;
        this.mVelocity = velocity;
    }

    public Coordinate2D getPosition() {
        return mPosition;
    }

    public Coordinate2D getVelocity() {
        return mVelocity;
    }

    public void addVelocity(Coordinate2D dVelocity) {
        this.mVelocity.translate(dVelocity.x, dVelocity.y);
    }

    public void update() {
        this.mPosition.translate(mVelocity.x, mVelocity.y);
        mAppearance.setLayoutX(mPosition.x);
        mAppearance.setLayoutY(mPosition.y);

        double adjacent, opposite;

        if (Math.abs(mVelocity.x) > Math.abs(mVelocity.y)) {
            adjacent = mVelocity.x;
            opposite = mVelocity.y;
        } else {
            adjacent = mVelocity.y;
            opposite = mVelocity.x;
        }

        Double angle = Math.toDegrees(Math.atan(opposite/adjacent));

        mAppearance.setRotate(angle);
    }
}
