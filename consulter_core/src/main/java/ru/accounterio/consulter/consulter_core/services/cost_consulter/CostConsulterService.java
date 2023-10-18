package ru.accounterio.consulter.consulter_core.services.cost_consulter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accounterio.consulter.consulter_core.domains.CostSituation;
import ru.accounterio.consulter.consulter_core.domains.Situation;
import ru.accounterio.consulter.consulter_core.dto.Advice;
import ru.accounterio.consulter.consulter_core.dto.Consultation;
import ru.accounterio.consulter.consulter_core.exceptions.ConsultationException;
import ru.accounterio.consulter.consulter_core.exceptions.FormatException;
import ru.accounterio.consulter.consulter_core.interfaces.Consulter;
import ru.accounterio.consulter.consulter_core.services.cost_consulter.util.CostSituationFormatter;

@Service
public class CostConsulterService implements Consulter<CostSituation> {
    private final CostSituationFormatter formatter;

    @Autowired
    public CostConsulterService(CostSituationFormatter formatter) {
        this.formatter = formatter;
    }

    public CostSituation format(Situation situation) throws FormatException {
        return CostSituation.of(formatter.format(situation));
    }

    @Override
    public Consultation consult(CostSituation costSituation) throws ConsultationException {
        return null;
    }

    @Override
    public Advice advice(CostSituation costSituation) throws ConsultationException {
        return null;
    }
}
