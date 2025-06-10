package com.cdwarehouse;

public class CD
{
    public boolean buyCD(String title, CDStock cdStock, Payment payment, NotifySales notifySale) {

        if (cdStock.getStock(title) > 0) {
            if (payment.checkPaymentStatus()) {
                cdStock.reduceStock(title);
                notifySale.notificationCompleted(title, "artist", 1);
                return true;
            }
        }
        return false;
    }

    public double getPrice(String title, TopAlbums topAlbums, CompetitorPrice competitorPrice) {
        if(topAlbums.checkAlbumIsInTop(title, 100)) {
            return competitorPrice.getCompetitorPrice(title)-1;
        }
        return 9.99;
    }
}
