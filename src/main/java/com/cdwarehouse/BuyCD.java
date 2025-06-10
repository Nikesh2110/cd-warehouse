package com.cdwarehouse;

public class BuyCD {
    public boolean buyCD(String title, CDStock cdStock) {
        Payment payment = new CardPayment();
        if (cdStock.getStock(title) > 0) {
            if (payment.checkPaymentStatus()) {
                cdStock.reduceStock(title);
                return true;
            }
        }
        return false;
    }
}
