package ru.accounterio.consulter.consulter_core.dto;

import java.io.Serializable;
import java.time.Instant;

public interface Response extends Serializable {
    Long userId();
    String value();
    Instant stamp();
}
