package ru.accounterio.consulter.consulter_core.domains;

public class CostSituation extends Situation {
    private CostSituation(Target target) {}

    public static CostSituation of(Target target) {
        return new CostSituation(target);
    }
}
