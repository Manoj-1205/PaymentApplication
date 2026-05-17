package com.systemdesign.paymentapplication.services;

import com.systemdesign.paymentapplication.dtos.PaymentRequest;
import com.systemdesign.paymentapplication.entities.Transaction;
import com.systemdesign.paymentapplication.entities.TransactionStatus;
import com.systemdesign.paymentapplication.entities.UserEntity;
import com.systemdesign.paymentapplication.entities.Wallet;
import com.systemdesign.paymentapplication.repositories.TransactionRepository;
import com.systemdesign.paymentapplication.repositories.UserRepository;
import com.systemdesign.paymentapplication.repositories.WalletRepository;
import com.systemdesign.paymentapplication.services.strategies.PaymentFactory;
import com.systemdesign.paymentapplication.services.strategies.PaymentStrategy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;
    private final PaymentFactory paymentFactory;

    public PaymentService(
            UserRepository userRepository,
            WalletRepository walletRepository,
            TransactionRepository transactionRepository, PaymentFactory paymentFactory) {

        this.userRepository = userRepository;
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
        this.paymentFactory = paymentFactory;
    }

    @Transactional
    public String transferMoney(PaymentRequest request) {

        UserEntity sender = userRepository.findById(request.getSenderId())
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        UserEntity receiver = userRepository.findById(request.getReceiverId())
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        Wallet senderWallet = walletRepository.findByUserUserId(sender.getUserId())
                .orElseThrow(() -> new RuntimeException("Sender wallet not found"));

        Wallet receiverWallet = walletRepository.findByUserUserId(receiver.getUserId())
                .orElseThrow(() -> new RuntimeException("Receiver wallet not found"));

        if (senderWallet.getBalance().compareTo(request.getAmount()) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        // debit sender
        senderWallet.setBalance(
                senderWallet.getBalance().subtract(request.getAmount()));

        // credit receiver
        receiverWallet.setBalance(
                receiverWallet.getBalance().add(request.getAmount()));

        walletRepository.save(senderWallet);
        walletRepository.save(receiverWallet);

        Transaction transaction = new Transaction();
        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setAmount(request.getAmount());
        transaction.setStatus(TransactionStatus.SUCCESS);

        transactionRepository.save(transaction);

        return "Transaction Successful";
    }

    public String sendMoney(PaymentRequest request) {
        String paymentMode = request.getPaymentMode();
        PaymentStrategy paymentStrategy = paymentFactory.getPaymentStrategy(paymentMode);

        return paymentStrategy.payment(request);
    }
}
