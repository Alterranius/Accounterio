package ru.accounterio.receiptai.receiptai_processor.services.classificator.classifiers;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.accounterio.receiptai.receiptai_processor.domains.Category;
import ru.accounterio.receiptai.receiptai_processor.domains.Position;
import ru.accounterio.receiptai.receiptai_processor.interfaces.util.Classifier;

@Component
public class CostClassifier implements Classifier<Position, Category> {
    private final OpenAiChatModel openAiChatModel;

    @Autowired
    public CostClassifier(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }

    @Override
    public Category classify(Position source) {
        return null;
    }
}
