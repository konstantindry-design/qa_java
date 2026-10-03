package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlexTest {

    @Test
    public void getFriendsReturnsThreeFriends() throws Exception {
        Alex alex = new Alex(new Feline());
        assertEquals(List.of("Зебра Марти", "Бегемотиха Глория", "Жираф Мелман"),
                alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingReturnsZoo() throws Exception {
        Alex alex = new Alex(new Feline());
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void getKittensReturnsZero() throws Exception {
        Alex alex = new Alex(new Feline());
        assertEquals(0, alex.getKittens());
    }

    @Test
    public void alexIsMaleAndHasMane() throws Exception {
        Alex alex = new Alex(new Feline());
        assertTrue(alex.doesHaveMane());
    }
}

