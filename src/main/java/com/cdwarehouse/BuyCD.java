package com.cdwarehouse;

public class BuyCD
{
    public boolean buyCD(String title)
    {
        CDStock cdStock = new CDStock();
        Payment payment = new Payment();
        if(cdStock.checkCDinStock(title)){
            return payment.checkPaymentStatus();
        }
        return false;
    }
}
