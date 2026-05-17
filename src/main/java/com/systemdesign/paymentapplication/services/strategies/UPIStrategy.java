package com.systemdesign.paymentapplication.services.strategies;

import org.springframework.stereotype.Component;

@Component
public class UPIStrategy implements PaymentStrategy{

    @Override
    public String payment(java.math.BigDecimal amount) {
        return "UPI payment of amount: " + amount + " processed successfully.";
    }

    @Override
    public String getType() {
        return "UPI";
    }

    @Override
    public boolean validate() {
        // Implement UPI validation logic here
        return true;
    }
}
