package ru.accounterio.consulter.consulter_core.services.cost_consulter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accounterio.consulter.consulter_core.domains.CostSituation;
import ru.accounterio.consulter.consulter_core.domains.Target;
import ru.accounterio.consulter.consulter_core.dto.Advice;
import ru.accounterio.consulter.consulter_core.dto.Consultation;
import ru.accounterio.consulter.consulter_core.interfaces.Consulter;
import ru.accounterio.consulter.consulter_core.services.cost_consulter.util.CostSituationFormatter;

@Service
public class CostConsulterService implements Consulter<CostSituation> {
    private final CostSituationFormatter formatter;
    private CostSituation situation;

    @Autowired
    public CostConsulterService(CostSituationFormatter formatter) {
        this.formatter = formatter;
    }

    public Target format(CostSituation costSituation) {
        return formatter.format(costSituation);
    }

    @Override
    public Consultation consult(CostSituation costSituation) {
        return null;
    }

    @Override
    public Advice advice(CostSituation costSituation) {
        return null;
    }
}
