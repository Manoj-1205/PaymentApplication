package com.systemdesign.paymentapplication.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "bankAccount")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankId;
    private String bankName;

    @Column(nullable = false)
    private String accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @Column(nullable = false)
    private String ifscCode;

    @Column(nullable = false)
    private BigDecimal balance;
}
