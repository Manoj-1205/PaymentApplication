package com.systemdesign.paymentapplication.services.strategies;

import com.systemdesign.paymentapplication.dtos.PaymentRequest;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UPIStrategy implements PaymentStrategy{

    @Override
    public String payment(PaymentRequest request) {
        if(!validate(request)){
            return "Invalid UPI payment request.";
        }
        return "UPI payment of amount: " + request.getAmount() + " processed successfully.";
    }

    @Override
    public String getType() {
        return "UPI";
    }

    @Override
    public boolean validate(PaymentRequest request) {
        Map<String, String> paymentDetails = request.getPaymentDetails();
        if (paymentDetails.get("upiId") == null || paymentDetails.get("upiId").isEmpty()) {
            return false;
        }
        return true;
    }
}
