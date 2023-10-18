package ru.accounterio.receiptai.receiptai_processor.interfaces;

import ru.accounterio.receiptai.receiptai_processor.dto.RecognitionResult;
import ru.accounterio.receiptai.receiptai_processor.domains.Recognizable;

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
    RecognitionResult recognize(Recognizable r);
}
