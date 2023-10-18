package ru.accounterio.consulter.consulter_core.interfaces;

import ru.accounterio.consulter.consulter_core.domains.Target;
import ru.accounterio.consulter.consulter_core.dto.Advice;
import ru.accounterio.consulter.consulter_core.dto.Consultation;

public interface Consulter<T extends Target> {
    Consultation consult(T t);
    Advice advice(T t);
}
