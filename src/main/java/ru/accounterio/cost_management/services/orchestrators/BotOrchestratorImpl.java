package ru.accounterio.cost_management.services.orchestrators;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import ru.accounterio.cost_management.interfaces.orchestrators.BotOrchestrator;
import ru.accounterio.cost_management.interfaces.orchestrators.OrchestrationException;

@Service
@Log4j
public class BotOrchestratorImpl implements BotOrchestrator {

    @Override
    public void orchestrateEndReceiptBP(Long id) throws OrchestrationException {
        // TODO: 21.10.2023 impl Bot Orchestra
    }

    @Override
    public void orchestrateEndAdviceBP(Long id) throws OrchestrationException {

    }

    @Override
    public void orchestrateEndConsultBP(Long id) throws OrchestrationException {

    }
}