package ru.accounterio.consulter.consulter_core.services.cost_consulter;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accounterio.consulter.consulter_core.domains.CostSituation;
import ru.accounterio.consulter.consulter_core.domains.Situation;
import ru.accounterio.consulter.consulter_core.dto.*;
import ru.accounterio.consulter.consulter_core.exceptions.FormatException;
import ru.accounterio.consulter.consulter_core.interfaces.Consulter;
import ru.accounterio.consulter.consulter_core.services.cost_consulter.util.AdviceProducer;
import ru.accounterio.consulter.consulter_core.services.cost_consulter.util.ConsultationProducer;
import ru.accounterio.consulter.consulter_core.services.cost_consulter.util.CostSituationFormatter;
import ru.accounterio.consulter.consulter_core.services.tasks.Task;

import java.util.Map;
import java.util.function.Function;

@Service
public class CostConsulterService implements Consulter<CostSituation> {
    private final CostSituationFormatter formatter;
    private final AdviceProducer adviceProducer;
    private final ConsultationProducer consultationProducer;
    private final AccounterioCoreClient accounterioCoreClient;
    private final Map<String, Function<CostSituation, Response>> funs =
            Map.of(Task.CONSULTATION_COMMAND, this::consult, Task.ADVICE_COMMAND, this::advice);

    @Autowired
    public CostConsulterService(CostSituationFormatter formatter, AdviceProducer adviceProducer, ConsultationProducer consultationProducer, AccounterioCoreClient accounterioCoreClient) {
        this.formatter = formatter;
        this.adviceProducer = adviceProducer;
        this.consultationProducer = consultationProducer;
        this.accounterioCoreClient = accounterioCoreClient;
    }

    public CostSituation format(Situation situation) throws FormatException {
        return CostSituation.of(formatter.format(situation));
    }

    @Override
    public Consultation consult(CostSituation costSituation) {
        return null;
    }

    @Override
    public Advice advice(CostSituation costSituation) {
        return null;
    }

    @RabbitListener(queues = {"consultant-queue"})
    public void consumeTasks(Task<CostSituation, Response> task) {
        task.execute(funs).ifPresent(this::successCallback);
    }

    public void successCallback(Response response) {
        switch (response) {
            case Consultation c -> {
                consultationProducer.sendMessage(new ConsultBotTask(c, Task.CONSULTATION_COMMAND));
                accounterioCoreClient.notifyOnConsultation(response.userId());
            }
            case Advice a -> {
                adviceProducer.sendMessage(new AdviceBotTask(a, Task.ADVICE_COMMAND));
                accounterioCoreClient.notifyOnAdvice(response.userId());
            }
            default -> {}
        }
    }
}
