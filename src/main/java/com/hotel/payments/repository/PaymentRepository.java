package com.hotel.payments.repository;

import com.hotel.payments.enitity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}