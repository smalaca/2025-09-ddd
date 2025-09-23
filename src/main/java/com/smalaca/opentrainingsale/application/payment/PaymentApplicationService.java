package com.smalaca.opentrainingsale.application.payment;

import com.smalaca.opentrainingsale.domain.payment.Payment;
import com.smalaca.opentrainingsale.domain.payment.PaymentRepository;

public class PaymentApplicationService {
    private final PaymentRepository paymentRepository;

    public PaymentApplicationService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void pay() {

        // To nie jest jedna linia kodu!!!
        // co tutaj jest źle??
        Payment payment = new Payment();
        payment.pay();

        paymentRepository.save(payment);
    }
}
