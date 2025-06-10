package com.cdwarehouse;

public class CDStock {

    public int getStock() {
        return 1;
    }

    public boolean checkCDinStock(String title)
    {
        if (title.equals("ABC")) {
            return true;
        }
        return false;
    }
}
