package com.basma.categorie.repository;

import com.basma.categorie.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
   Payment findByIdPayment(Long id);
}
