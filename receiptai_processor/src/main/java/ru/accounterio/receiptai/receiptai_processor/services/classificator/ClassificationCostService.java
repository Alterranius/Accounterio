package ru.accounterio.receiptai.receiptai_processor.services.classificator;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accounterio.receiptai.receiptai_processor.domains.CostSet;
import ru.accounterio.receiptai.receiptai_processor.domains.Position;
import ru.accounterio.receiptai.receiptai_processor.services.classificator.classifiers.CostClassifier;

@Service
public class ClassificationCostService {
    private final CostClassifier costClassifier;

    @Autowired
    public ClassificationCostService(CostClassifier costClassifier) {
        this.costClassifier = costClassifier;
    }

    @Timed("classificationTime")
    public CostSet classify(CostSet costSet) {
        return null; //new Position(position.name(), position.price(), costClassifier.classify(position));
    }
}
