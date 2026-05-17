package com.systemdesign.paymentapplication.services.strategies;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PaymentFactory {
    private final Map<String, PaymentStrategy> strategyMap = new HashMap<>();
    private final List<PaymentStrategy> paymentStrategies;

    public PaymentFactory(List<PaymentStrategy> paymentStrategies){
        this.paymentStrategies = paymentStrategies;
    }

    @PostConstruct
    private void buildMap(){
        paymentStrategies
                .forEach(paymentMode -> strategyMap.put(paymentMode.getType(), paymentMode));
    }

    public PaymentStrategy getPaymentStrategy(String type){

        return strategyMap.get(type);
    }

}
