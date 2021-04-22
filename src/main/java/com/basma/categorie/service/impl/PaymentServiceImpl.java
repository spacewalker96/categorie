package com.basma.categorie.service.impl;

import com.basma.categorie.entity.Payment;
import com.basma.categorie.repository.PaymentRepository;
import com.basma.categorie.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findByIdPayment(Long id) {
        return paymentRepository.findByIdPayment(id);
    }

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(Long id) {
    Payment payment = paymentRepository.findByIdPayment(id);
    paymentRepository.deleteById(payment.getId());

    }
}
