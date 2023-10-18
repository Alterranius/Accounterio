package ru.accounterio.receiptai.receiptai_processor.services.classificator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accounterio.receiptai.receiptai_processor.services.classificator.classifiers.CostClassifier;

@Service
public class ClassificationService {
    private final CostClassifier costClassifier;

    @Autowired
    public ClassificationService(CostClassifier costClassifier) {
        this.costClassifier = costClassifier;
    }
}
