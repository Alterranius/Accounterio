package ru.accounterio.consulter.consulter_core.services.cost_consulter.util;

import org.springframework.stereotype.Component;
import ru.accounterio.consulter.consulter_core.domains.CostSituation;
import ru.accounterio.consulter.consulter_core.domains.Target;
import ru.accounterio.consulter.consulter_core.interfaces.Formatter;

@Component
public class CostSituationFormatter implements Formatter<CostSituation> {
    @Override
    public Target format(CostSituation costSituation) {
        return null;
    }
}
