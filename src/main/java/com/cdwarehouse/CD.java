package com.cdwarehouse;

public class CD
{

    private Payment payment;
    private NotifySales notifySale;

    public CD(Payment payment, NotifySales notifySale)
    {
        this.payment = payment;
        this.notifySale = notifySale;
    }

    public boolean buyCD(String title, CDStock cdStock) {

        if (cdStock.getStock(title) > 0) {
            if (payment.checkPaymentStatus()) {
                cdStock.reduceStock(title);
                notifySale.notificationCompleted(title, "artist", 1);
                return true;
            }
        }
        return false;
    }
}
