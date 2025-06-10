package com.cdwarehouse;

public class BuyCD
{
    public boolean buyCD(String title)
    {
        CDStock cdStock = new CDStock(10);
        Payment payment = new CardPayment();
        if(cdStock.getStock(title) > 0){
            if(payment.checkPaymentStatus())
            {
                return true;
            }
        }
        return false;
    }
}
