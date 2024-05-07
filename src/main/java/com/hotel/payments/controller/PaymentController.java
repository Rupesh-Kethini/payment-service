package com.hotel.payments.controller;

import com.hotel.payments.enitity.Payment;
import com.hotel.payments.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class PaymentController {

    private PaymentRepository paymentRepository;

    @PostMapping
    public ResponseEntity<Payment> makePayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentRepository.save(payment);
        return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        if (payment != null) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
