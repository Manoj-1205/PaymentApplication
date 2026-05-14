package com.systemdesign.paymentapplication.repositories;

import com.systemdesign.paymentapplication.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Optional<Wallet> findByUserUserId(Long userId);
}
