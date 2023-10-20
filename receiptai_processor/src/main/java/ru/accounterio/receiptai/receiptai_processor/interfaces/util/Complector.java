package ru.accounterio.receiptai.receiptai_processor.interfaces.util;

import ru.accounterio.receiptai.receiptai_processor.dto.RecognitionResult;
import ru.accounterio.receiptai.receiptai_processor.interfaces.exceptions.ComplectionException;

/**
 * Performer complectation of recognition result
 * @param <T> target type
 */
@FunctionalInterface
public interface Complector<T> {
    /**
     * Perform complectation
     * @param from object needs to complect
     * @return complected type
     */
    T complect(RecognitionResult from) throws ComplectionException;
}
