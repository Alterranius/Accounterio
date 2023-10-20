package ru.accounterio.cost_management.interfaces.orchestrators;

import ru.accounterio.cost_management.dto.ReceiptImage;

public interface ReceiptAIProcessorOrchestrator {
    void orchestrateAddReceiptBP(ReceiptImage receiptImage) throws OrchestrationException;
}
