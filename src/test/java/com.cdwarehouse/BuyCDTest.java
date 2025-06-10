package com.cdwarehouse;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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
        NotifySales notifySale = mock(NotifySales.class);
        CD buyCD = new CD();
        CDStock cdStock = new CDStock(10);
        String title = "ABC";
        Mockito.when(payment.checkPaymentStatus()).thenReturn(true);
        assertTrue(buyCD.buyCD(title, cdStock,payment,notifySale));
        assertEquals(9, cdStock.getStock(title));
    }

    @Test
    void buyCDWhenPaymentIsNotSuccessful() {
        Payment payment = Mockito.mock(Payment.class);
        NotifySales notifySale = mock(NotifySales.class);
        CD buyCD = new CD();
        CDStock cdStock = new CDStock(10);
        String title = "ABC";
        Mockito.when(payment.checkPaymentStatus()).thenReturn(false);
        assertFalse(buyCD.buyCD(title, cdStock,payment,notifySale));
        assertEquals(10, cdStock.getStock(title));
    }

    @Test
    void checkCDIsNotInStockWhenBuying(){
        Payment payment = Mockito.mock(Payment.class);
        NotifySales notifySale = mock(NotifySales.class);
        CD buyCD = new CD();
        assertFalse(buyCD.buyCD("XYZ", new CDStock(10),payment,notifySale));
    }

}
