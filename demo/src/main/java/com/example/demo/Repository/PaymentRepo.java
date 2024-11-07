package com.example.demo.Repository;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {

    Optional<Payment> findByCartPaymentId(long cartPaymentId);
}
