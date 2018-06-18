package github.com.PERS23.Boids;

import java.util.ArrayList;
import java.util.List;

public class BoidFlock {

    private List<Boid> mBoids = new ArrayList<>();
    private List<BoidRule> mRuleList = new ArrayList<>();

    public BoidFlock() {
        mRuleList.add(new Centering());
        mRuleList.add(new Distancing());
        mRuleList.add(new Matching());
    }

    public void update() {
        for (Boid b : mBoids) {
            for (BoidRule rule : mRuleList) {
                b.velocity.add(rule.calculate(mBoids, b));
            }
            b.position.translate(b.velocity.xMagnitude, b.velocity.yMagnitude);
        }
    }
}
