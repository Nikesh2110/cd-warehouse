package com.cdwarehouse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TopAlbumsTest {

    @Test
    void top100Albums() {
        TopAlbums topAlbums = mock(TopAlbums.class);
        CD cd = new CD();
        CompetitorPrice competitorPrice = mock(CompetitorPrice.class);
        cd.getPrice("ABC", topAlbums, competitorPrice);
        verify(topAlbums).checkAlbumIsInTop("ABC", 100);
    }

    @Test
    void competitorPrice() {
        TopAlbums topAlbums = mock(TopAlbums.class);
        CD cd = new CD();
        CompetitorPrice competitorPrice = mock(CompetitorPrice.class);
        when(topAlbums.checkAlbumIsInTop("ABC", 100)).thenReturn(true);
        cd.getPrice("ABC", topAlbums, competitorPrice);
        verify(competitorPrice).getCompetitorPrice("ABC");

    }

    @Test
    void top100AlbumsPriceReduction(){
        TopAlbums topAlbums = mock(TopAlbums.class);
        CD cd = new CD();
        CompetitorPrice competitorPrice = mock(CompetitorPrice.class);
        when(topAlbums.checkAlbumIsInTop("ABC", 100)).thenReturn(true);
        when(competitorPrice.getCompetitorPrice("ABC")).thenReturn(19.99);
        assertEquals(18.99, cd.getPrice("ABC", topAlbums,competitorPrice));
    }

    @Test
    void albumNotInTop100(){
        TopAlbums topAlbums = mock(TopAlbums.class);
        CD cd = new CD();
        CompetitorPrice competitorPrice = mock(CompetitorPrice.class);
        when(topAlbums.checkAlbumIsInTop("ABC", 100)).thenReturn(false);
        assertEquals(9.99,cd.getPrice("ABC", topAlbums, competitorPrice));
    }
}
