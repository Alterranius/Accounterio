package ru.accounterio.consulter.consulter_core.services.cost_consulter.util;

import org.springframework.stereotype.Component;
import ru.accounterio.consulter.consulter_core.domains.Situation;
import ru.accounterio.consulter.consulter_core.domains.Target;
import ru.accounterio.consulter.consulter_core.interfaces.Formatter;

@Component
public class CostSituationFormatter implements Formatter<Situation> {
    @Override
    public Target format(Situation situation) {
        return null;
    }
}
