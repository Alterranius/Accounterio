package ru.accounterio.receiptai.receiptai_processor.interfaces;

import ru.accounterio.receiptai.receiptai_processor.domains.CostSet;
import ru.accounterio.receiptai.receiptai_processor.dto.ReceiptImage;

public interface ReceiptProcessor {
    CostSet processReceipt(ReceiptImage receiptImage);
    void successCallback(CostSet costSet);
}
