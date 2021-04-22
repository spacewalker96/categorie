package com.basma.categorie.service;

import com.basma.categorie.entity.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> getPayments();
    Payment findByIdPayment(Long id);
    Payment savePayment(Payment payment);
    void deletePayment(Long id) ;
}
