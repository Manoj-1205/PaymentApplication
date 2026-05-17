package com.systemdesign.paymentapplication.services.strategies;

import com.systemdesign.paymentapplication.dtos.PaymentRequest;

import java.math.BigDecimal;

public interface PaymentStrategy {
    String payment(PaymentRequest request);
    String getType();
    boolean validate(PaymentRequest request);

}
