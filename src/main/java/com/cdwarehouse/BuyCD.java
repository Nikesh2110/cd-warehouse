package com.cdwarehouse;

public class BuyCD
{
    public boolean buyCD(String title)
    {
        CDStock cdStock = new CDStock(10);
        Payment payment = new Payment();
        if(cdStock.checkCDinStock(title)){
            return payment.checkPaymentStatus();
        }
        return false;
    }
}
