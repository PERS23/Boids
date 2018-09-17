package PERS23.Boids;

public enum MovementRuleSet {
    CENTERING(new Centering()),
    DISTANCING(new Distancing()),
    MATCHING(new Matching());

    private MovementRule mRule;

    MovementRuleSet(MovementRule rule) {
        mRule = rule;
    }

    public MovementRule getRule() {
        return mRule;
    }
}
