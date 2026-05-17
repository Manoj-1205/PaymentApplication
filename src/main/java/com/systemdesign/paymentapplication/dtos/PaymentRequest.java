package com.systemdesign.paymentapplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    private Long senderId;
    private Long receiverId;
    private BigDecimal amount;
    private Map<String, String> paymentDetails;
    private String paymentMode;

}
