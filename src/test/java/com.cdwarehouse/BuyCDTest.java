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
    void reduceCDStock() {
        CDStock cdStock = new CDStock(10);
        assertEquals(9, cdStock.reduceStock("ABC"));
    }

    @Test
    void buyCDWhenPaymentIsSuccessful() {
        Payment payment = Mockito.mock(Payment.class);
        BuyCD buyCD = new BuyCD();
        CDStock cdStock = new CDStock(10);
        String title = "ABC";
        Mockito.when(payment.checkPaymentStatus()).thenReturn(true);
        assertTrue(buyCD.buyCD(title, cdStock));
        assertEquals(9, cdStock.getStock(title));
    }

    @Test
    void buyCDWhenPaymentIsNotSuccessful() {
        Payment payment = Mockito.mock(Payment.class);
        BuyCD buyCD = new BuyCD();
        Mockito.when(payment.checkPaymentStatus()).thenReturn(false);
        assertTrue(buyCD.buyCD("ABC", new CDStock(10)));
    }

}
