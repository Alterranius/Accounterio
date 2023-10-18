package ru.accounterio.consulter.consulter_core.interfaces;

import ru.accounterio.consulter.consulter_core.domains.Situation;
import ru.accounterio.consulter.consulter_core.domains.Target;
import ru.accounterio.consulter.consulter_core.dto.Advice;
import ru.accounterio.consulter.consulter_core.dto.Consultation;
import ru.accounterio.consulter.consulter_core.exceptions.ConsultationException;
import ru.accounterio.consulter.consulter_core.exceptions.FormatException;

public interface Consulter<T extends Target> {
    Consultation consult(T t) throws ConsultationException;
    Advice advice(T t) throws ConsultationException;
    T format(Situation s) throws FormatException;
}
