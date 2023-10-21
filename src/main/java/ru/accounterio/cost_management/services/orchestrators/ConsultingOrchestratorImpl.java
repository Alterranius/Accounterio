package ru.accounterio.cost_management.services.orchestrators;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import ru.accounterio.cost_management.interfaces.orchestrators.ConsultingOrchestrator;
import ru.accounterio.cost_management.interfaces.orchestrators.OrchestrationException;

@Service
@Log4j
public class ConsultingOrchestratorImpl implements ConsultingOrchestrator {

    public void orchestrateConsultBP(Long id) throws OrchestrationException {
    }

    public void orchestrateAdviceBP(Long id) throws OrchestrationException {
    }

    @Override
    public void orchestrateEndConsultBP(Long id) throws OrchestrationException {

    }

    @Override
    public void orchestrateEndAdviceBP(Long id) throws OrchestrationException {

    }
}
