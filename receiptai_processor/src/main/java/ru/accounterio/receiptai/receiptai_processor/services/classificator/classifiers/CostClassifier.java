package ru.accounterio.receiptai.receiptai_processor.services.classificator.classifiers;

import org.springframework.stereotype.Component;
import ru.accounterio.receiptai.receiptai_processor.domains.Category;
import ru.accounterio.receiptai.receiptai_processor.domains.Position;
import ru.accounterio.receiptai.receiptai_processor.interfaces.util.Classifier;

@Component
public class CostClassifier implements Classifier<Position, Category> {
    @Override
    public Category classify(Position source) {
        return null;
    }
}
