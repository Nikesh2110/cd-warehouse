package com.cdwarehouse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TopAlbumsTest {

    @Test
    void top100Albums() {
        Payment payment = mock(Payment.class);
        NotifySales notifySale = mock(NotifySales.class);
        TopAlbums topAlbums = mock(TopAlbums.class);
        CD cd = new CD(payment, notifySale);
        CompetitorPrice competitorPrice = mock(CompetitorPrice.class);
        cd.getPrice("ABC", topAlbums, competitorPrice);
        verify(topAlbums).checkAlbumIsInTop("ABC", 100);
    }

    @Test
    void competitorPrice() {
        Payment payment = mock(Payment.class);
        NotifySales notifySale = mock(NotifySales.class);
        TopAlbums topAlbums = mock(TopAlbums.class);
        CD cd = new CD(payment, notifySale);
        CompetitorPrice competitorPrice = mock(CompetitorPrice.class);
        when(topAlbums.checkAlbumIsInTop("ABC", 100)).thenReturn(true);
        cd.getPrice("ABC", topAlbums, competitorPrice);
        verify(competitorPrice).getCompetitorPrice("ABC");

    }

    @Test
    void top100AlbumsPriceReduction(){
        Payment payment = mock(Payment.class);
        NotifySales notifySale = mock(NotifySales.class);
        TopAlbums topAlbums = mock(TopAlbums.class);
        CD cd = new CD(payment, notifySale);
        CompetitorPrice competitorPrice = mock(CompetitorPrice.class);
        when(topAlbums.checkAlbumIsInTop("ABC", 100)).thenReturn(true);
        when(competitorPrice.getCompetitorPrice("ABC")).thenReturn(19.99);
        assertEquals(18.99, cd.getPrice("ABC", topAlbums,competitorPrice));
    }

    @Test
    void albumNotInTop100(){
        Payment payment = mock(Payment.class);
        NotifySales notifySale = mock(NotifySales.class);
        TopAlbums topAlbums = mock(TopAlbums.class);
        CD cd = new CD(payment, notifySale);
        CompetitorPrice competitorPrice = mock(CompetitorPrice.class);
        when(topAlbums.checkAlbumIsInTop("ABC", 100)).thenReturn(false);
        assertEquals(9.99,cd.getPrice("ABC", topAlbums, competitorPrice));
    }
}
