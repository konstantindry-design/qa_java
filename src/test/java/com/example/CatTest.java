package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {

    @Test
    public void getSoundReturnsMeow() {
        Cat cat = new Cat(Mockito.mock(Predator.class));
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodDelegatesToPredator() throws Exception {
        Predator predatorMock = Mockito.mock(Predator.class);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(predatorMock.eatMeat()).thenReturn(expected);
        Cat cat = new Cat(predatorMock);
        assertEquals(expected, cat.getFood());
    }
}

