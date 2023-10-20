package ru.accounterio.cost_management.interfaces.orchestrators;

public interface ConsultingOrchestrator {
    void orchestrateConsultBP(Long id) throws OrchestrationException;
    void orchestrateAdviceBP(Long id) throws OrchestrationException;
}
