package com.cdwarehouse;

public class CDStock {

    private int cdStock = 10;

    public CDStock(int cdStock)
    {
        this.cdStock = cdStock;
    }

    public int getStock(String title) {
        if (title.equals("ABC"))
        {
            return cdStock;
        }
        return 0;
    }
}
