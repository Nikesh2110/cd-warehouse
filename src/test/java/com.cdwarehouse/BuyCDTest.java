package com.cdwarehouse;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class BuyCDTest {

    @Test
    void getCDStock() {
        CDStock cdStock = new CDStock(10);
        assertEquals(10, cdStock.getStock("ABC"));
    }

    @Test
    void buyCDWhenPaymentIsSuccessful()
    {
        Payment payment = Mockito.mock(Payment.class);
        BuyCD buyCD = new BuyCD();
        Mockito.when(payment.checkPaymentStatus()).thenReturn(true);
        assertTrue(buyCD.buyCD("ABC"));
    }

    @Test
    void buyCDWhenPaymentIsNotSuccessful()
    {
        Payment payment = Mockito.mock(Payment.class);
        BuyCD buyCD = new BuyCD();
        Mockito.when(payment.checkPaymentStatus()).thenReturn(false);
        assertTrue(buyCD.buyCD("ABC"));
    }

}
