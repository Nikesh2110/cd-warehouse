package com.cdwarehouse;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TopAlbumsTest {
    @Test
    void top100AlbumsPriceReduction() {
        Payment payment = mock(Payment.class);
        NotifySales notifySale = mock(NotifySales.class);
        TopAlbums topAlbums = mock(TopAlbums.class);
        CD cd = new CD(payment, notifySale);
        CompetitorPrice competitorPrice = mock(CompetitorPrice.class);
        when(topAlbums.checkAlbumIsInTop("ABC", 100)).thenReturn(true);
        cd.getPrice("ABC", topAlbums, competitorPrice);
        verify(topAlbums).checkAlbumIsInTop("ABC", 100);

        verify(competitorPrice).getCompetitorPrice("ABC");
    }
}
