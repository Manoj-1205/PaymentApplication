package com.systemdesign.paymentapplication.services.strategies;

import java.math.BigDecimal;

public interface PaymentStrategy {
    String payment(BigDecimal amount);
    String getType();
    boolean validate();

}
