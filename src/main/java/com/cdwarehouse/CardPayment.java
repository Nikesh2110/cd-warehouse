package com.cdwarehouse;

public class CardPayment implements Payment {

    @Override
    public boolean checkPaymentStatus() {
        return true;
    }
}
