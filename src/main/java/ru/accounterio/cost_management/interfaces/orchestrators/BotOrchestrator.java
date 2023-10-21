package ru.accounterio.cost_management.interfaces.orchestrators;

public interface BotOrchestrator {
    void orchestrateEndReceiptBP(Long id) throws OrchestrationException;

    void orchestrateEndAdviceBP(Long id) throws OrchestrationException;

    void orchestrateEndConsultBP(Long id) throws OrchestrationException;
}
