package com.cdwarehouse;

public class CDStock {

    private int cdStock = 10;

    public CDStock(int cdStock)
    {
        this.cdStock = cdStock;
    }

    public int getStock() {
        return cdStock;
    }

    public boolean checkCDinStock(String title)
    {
        if (title.equals("ABC")) {
            return true;
        }
        return false;
    }
}
