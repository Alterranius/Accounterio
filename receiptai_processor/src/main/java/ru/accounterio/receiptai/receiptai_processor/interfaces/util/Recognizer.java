package ru.accounterio.receiptai.receiptai_processor.interfaces.util;

import ru.accounterio.receiptai.receiptai_processor.dto.RecognitionResult;
import ru.accounterio.receiptai.receiptai_processor.domains.Recognizable;
import ru.accounterio.receiptai.receiptai_processor.interfaces.exceptions.RecognitionException;

/**
 * Performer CV recognition
 */
@FunctionalInterface
public interface Recognizer {
    /**
     * Perform CV recognition
     *
     * @param r recognition source
     * @return recognition result
     */
    RecognitionResult recognize(Recognizable r) throws RecognitionException;
}
