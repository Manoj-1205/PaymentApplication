package com.systemdesign.paymentapplication.services.strategies;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CreditCardStrategy implements PaymentStrategy{

    @Override
    public String payment(BigDecimal amount) {
        return "CREDIT_CARD payment of amount: " + amount + " processed successfully.";
    }

    @Override
    public String getType() {
        return "CREDIT_CARD";
    }

    @Override
    public boolean validate() {
        return false;
    }
}
