package com.systemdesign.paymentapplication.controllers;

import com.systemdesign.paymentapplication.dtos.PaymentRequest;
import com.systemdesign.paymentapplication.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(
            @RequestBody PaymentRequest request) {

        return ResponseEntity.ok(
                paymentService.sendMoney(request));
    }
}
