package ru.accounterio.consulter.consulter_core.services.tasks;

import ru.accounterio.consulter.consulter_core.domains.CostSituation;
import ru.accounterio.consulter.consulter_core.domains.Situation;
import ru.accounterio.consulter.consulter_core.dto.Advice;
import ru.accounterio.consulter.consulter_core.dto.Consultation;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public sealed interface Task<I, R> extends Serializable {
    String CONSULTATION_COMMAND = "consult(user)";
    String ADVICE_COMMAND = "advice(user)";

    default Optional<R> execute(Map<String, Function<I, R>> funs) {
        return switch (this) {
            case ConsultCostTask(_, String command) when command.equals(CONSULTATION_COMMAND) ->
                    Optional.of(funs.get(CONSULTATION_COMMAND).apply(extract()));
            case AdviceCostTask(_, String command) when command.equals(ADVICE_COMMAND) ->
                    Optional.of(funs.get(ADVICE_COMMAND).apply(extract()));
            default -> {
                skip();
                yield Optional.empty();
            }
        };
    }

    I extract();

    void skip();
}

record ConsultCostTask(Situation situation, String command) implements Task<CostSituation, Consultation>, Serializable {
    @Override
    public CostSituation extract() {
        return CostSituation.of(situation);
    }

    @Override
    public void skip() {
    }
}

record AdviceCostTask(Situation situation, String command) implements Task<CostSituation, Advice>, Serializable {
    @Override
    public CostSituation extract() {
        return CostSituation.of(situation);
    }

    @Override
    public void skip() {
    }
}
