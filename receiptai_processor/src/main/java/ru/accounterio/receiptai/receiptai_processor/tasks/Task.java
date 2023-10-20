package ru.accounterio.receiptai.receiptai_processor.tasks;

import ru.accounterio.receiptai.receiptai_processor.domains.CostSet;
import ru.accounterio.receiptai.receiptai_processor.dto.ReceiptImage;

import java.util.Optional;
import java.util.function.Function;

public sealed interface Task<I, R> {
    String RECEIPT_PROCESSING_COMMAND = "process(receipt)";

    default Optional<R> execute(Function<I, R> fun) {
        return switch (this) {
            case ReceiptProcessTask(_, String command) when command.equals(RECEIPT_PROCESSING_COMMAND) ->
                    Optional.of(fun.apply(extract()));
            default -> {
                skip();
                yield Optional.empty();
            }
        };
    }

    I extract();

    void skip();
}

record ReceiptProcessTask(ReceiptImage input, String command) implements Task<ReceiptImage, CostSet> {

    @Override
    public ReceiptImage extract() {
        return input;
    }

    @Override
    public void skip() {
    }
}
