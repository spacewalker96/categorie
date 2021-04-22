package com.basma.categorie.service;

import com.basma.categorie.entity.Payment;
import com.basma.categorie.repository.PaymentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentServiceTest {

    @Autowired
    PaymentRepository paymentRepository;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPayments() {

        /*Date date = new Date(18/02/2021);
        Payment payment = new Payment(date,23.54,"bqdv dvvsd sdv","paypal");
        paymentRepository.save(payment);
        assertNotNull(paymentRepository.findAll().get());*/
        List<Payment> list = paymentRepository.findAll();

        assertThat(list).size().isGreaterThan(0);

    }

    @Test
    void findByIdPayment() {
    }

    @Test
    void savePayment() {
    }

    @Test
    void deletePayment() {
    }
}