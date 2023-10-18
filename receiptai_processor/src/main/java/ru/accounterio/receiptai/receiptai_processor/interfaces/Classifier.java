package ru.accounterio.receiptai.receiptai_processor.interfaces;

/**
 * Performer classification task
 * @param <S> source
 * @param <T> target
 */
@FunctionalInterface
public interface Classifier<S, T> {
    /**
     * Perform classification
     * @param source object to classify
     * @return target type
     */
    T classify(S source);
}
