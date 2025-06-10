package com.cdwarehouse;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;


public class NotificationOfSalesTest
{
    @Test
    void notifyForSales(){
        Payment payment = mock(Payment.class);
        NotifySales notifySale = mock(NotifySales.class);
        CDStock cdStock = new CDStock(10);
        CD buyCD = new CD();
        when(payment.checkPaymentStatus()).thenReturn(true);
        buyCD.buyCD("ABC", cdStock,payment, notifySale);
        verify(notifySale).notify("ABC", "artist", 1);
    }
}
