package com.cdwarehouse;

public class CDStock {

    private int cdStock;

    public CDStock(int cdStock) {
        this.cdStock = cdStock;
    }

    public int getStock(String title) {
        if (title.equals("ABC")) {
            return cdStock;
        }
        return 0;
    }

    public int reduceStock(String title) {
        if (title.equals("ABC")) {
            cdStock = cdStock - 1;
        }
        return cdStock;
    }
}
