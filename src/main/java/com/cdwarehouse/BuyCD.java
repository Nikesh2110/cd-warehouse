package com.cdwarehouse;

public class BuyCD {

    private Payment payment;

    public BuyCD(Payment payment){
        this.payment = payment;
    }

    public boolean buyCD(String title, CDStock cdStock) {

        if (cdStock.getStock(title) > 0) {
            if (payment.checkPaymentStatus()) {
                cdStock.reduceStock(title);
                return true;
            }
        }
        return false;
    }
}
