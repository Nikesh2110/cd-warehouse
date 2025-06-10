package com.cdwarehouse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BuyCDTest {

    @Test
    void checkPaymentIsSuccessful() {
        Payment payment = new Payment();
        assertTrue(payment.checkPaymentStatus());
    }

    @Test
    void buyCDWhenPaymentIsSuccessful() {
        CDStock cdStock = new CDStock();
        assertEquals(1, cdStock.getStock());
    }

    @Test
    void checkCDinStock(){
        CDStock cdStock = new CDStock();
        assertTrue(cdStock.checkCDinStock("ABC"));
    }

    @Test
    void checkCDNotInStock(){
        CDStock cdStock = new CDStock();
        assertFalse(cdStock.checkCDinStock("XYZ"));
    }

    @Test
    void buyCD()
    {
        BuyCD buyCD = new BuyCD();
        assertTrue(buyCD.buyCD("ABC"));
    }

}
