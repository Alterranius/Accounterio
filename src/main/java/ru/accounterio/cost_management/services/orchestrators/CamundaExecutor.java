package ru.accounterio.cost_management.services.orchestrators;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.accounterio.cost_management.services.orchestrators.processes.AbstractBP;

@Component
public class CamundaExecutor {
    private final RuntimeService runtimeService;

    @Autowired
    public CamundaExecutor(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public void startProcess(AbstractBP bp) {
        runtimeService.startProcessInstanceById(bp.getId());
    }
}
