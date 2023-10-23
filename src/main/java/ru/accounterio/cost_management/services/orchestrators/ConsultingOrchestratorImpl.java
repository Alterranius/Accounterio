package ru.accounterio.cost_management.services.orchestrators;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accounterio.cost_management.dto.Situation;
import ru.accounterio.cost_management.interfaces.orchestrators.ConsultingOrchestrator;
import ru.accounterio.cost_management.interfaces.orchestrators.OrchestrationException;
import ru.accounterio.cost_management.services.orchestrators.processes.advice.Advice;
import ru.accounterio.cost_management.services.orchestrators.processes.consult.Consult;
import ru.accounterio.cost_management.services.orchestrators.producers.ConsultantAdviceTaskProducer;
import ru.accounterio.cost_management.services.orchestrators.producers.ConsultantConsultTaskProducer;
import ru.accounterio.cost_management.services.orchestrators.tasks.TaskFactory;
import ru.accounterio.cost_management.services.orchestrators.tasks.commands.AdviceCostCommand;
import ru.accounterio.cost_management.services.orchestrators.tasks.commands.ConsultationCostCommand;

@Service
@Log4j
public class ConsultingOrchestratorImpl implements ConsultingOrchestrator {
    private final ConsultantAdviceTaskProducer adviceTaskProducer;
    private final ConsultantConsultTaskProducer consultTaskProducer;
    private final CamundaExecutor camundaExecutor;

    @Autowired
    public ConsultingOrchestratorImpl(ConsultantAdviceTaskProducer adviceTaskProducer, ConsultantConsultTaskProducer consultTaskProducer, CamundaExecutor camundaExecutor) {
        this.adviceTaskProducer = adviceTaskProducer;
        this.consultTaskProducer = consultTaskProducer;
        this.camundaExecutor = camundaExecutor;
    }

    public void orchestrateConsultBP(Long id) throws OrchestrationException {
        consultTaskProducer.sendMessage(new TaskFactory().withCommand(new ConsultationCostCommand()).createConsultUserTask(new Situation(null, null)));
        camundaExecutor.startProcess(new Consult());
        // TODO: 21.10.2023 impl Situation construction
    }

    public void orchestrateAdviceBP(Long id) throws OrchestrationException {
        adviceTaskProducer.sendMessage(new TaskFactory().withCommand(new AdviceCostCommand()).createAdviceUserTask(new Situation(null, null)));
        camundaExecutor.startProcess(new Advice());
    }

    @Override
    public void orchestrateEndConsultBP(Long id) throws OrchestrationException {
        // TODO: 21.10.2023 impl Consulting Orchestra
    }

    @Override
    public void orchestrateEndAdviceBP(Long id) throws OrchestrationException {

    }
}
