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
        CDStock cdStock = new CDStock(10);
        assertEquals(10, cdStock.getStock());
    }

    @Test
    void checkCDinStock(){
        CDStock cdStock = new CDStock(1);
        assertTrue(cdStock.checkCDinStock("ABC"));
    }

    @Test
    void checkCDNotInStock(){
        CDStock cdStock = new CDStock(0);
        assertFalse(cdStock.checkCDinStock("XYZ"));
    }

    @Test
    void buyCD()
    {
        BuyCD buyCD = new BuyCD();
        assertTrue(buyCD.buyCD("ABC"));
    }

}
