package ru.accounterio.consulter.consulter_core.interfaces;

import ru.accounterio.consulter.consulter_core.domains.Target;

/**
 * Performer formatting type into target
 * @param <T> type to format
 */
@FunctionalInterface
public interface Formatter<T> {
    /**
     * Perform formatting
     * @param t value to format
     * @return formatted target
     */
    Target format(T t);
}
