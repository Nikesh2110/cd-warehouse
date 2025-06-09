package com.cdwarehouse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuyCDTest {

    @Test
    void checkPaymentIsSuccessful() {
        Payment payment = new Payment();
        assertTrue(payment.checkPaymentStatus());
    }


}
