package com.systemdesign.paymentapplication.services.strategies;

import com.systemdesign.paymentapplication.dtos.PaymentRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class CreditCardStrategy implements PaymentStrategy{

    @Override
    public String payment(PaymentRequest request) {
        if (!validate(request)) {
            return "Invalid CREDIT_CARD payment request.";
        }
        return "CREDIT_CARD payment of amount: " + request.getAmount() + " processed successfully.";
    }

    @Override
    public String getType() {
        return "CREDIT_CARD";
    }

    @Override
    public boolean validate(PaymentRequest request) {
        Map<String, String> paymentDetails = request.getPaymentDetails();
        if(paymentDetails.get("cardNumber") == null ||paymentDetails.get("cvv") == null){
            return false;
        }
        if(paymentDetails.get("cardNumber").length() != 16 || paymentDetails.get("cvv").length() != 3 ||
            request.getAmount().compareTo(BigDecimal.ZERO) <= 0){
            return false;
        }
        return true;
    }
}
