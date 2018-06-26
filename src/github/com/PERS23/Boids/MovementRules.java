package github.com.PERS23.Boids;

public enum MovementRules {
    CENTERING(new Centering()),
    DISTANCING(new Distancing()),
    MATCHING(new Matching());

    private MovementRule mRule;

    MovementRules(MovementRule rule) {
        mRule = rule;
    }

    public MovementRule getRule() {
        return mRule;
    }
}
