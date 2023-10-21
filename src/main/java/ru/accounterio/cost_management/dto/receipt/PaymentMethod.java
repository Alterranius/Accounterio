package ru.accounterio.cost_management.dto.receipt;

import java.io.Serializable;

public enum PaymentMethod implements Serializable {
    CASH,
    DEBIT_CARD,
    CREDIT_CARD,
    TRANSFER,
    MOBILE,
    DIRECT,
    E_WALLET,
    QR,
    CRYPTOCURRENCY
}
