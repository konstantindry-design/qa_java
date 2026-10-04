package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LionCommonTest {

    @Test
    public void invalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class,
                () -> new Lion("Мутант", Mockito.mock(Predator.class)));
        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }

    @Test
    public void getKittensDelegatesToPredator() throws Exception {
        Predator predatorMock = Mockito.mock(Predator.class);
        Mockito.when(predatorMock.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", predatorMock);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void getFoodDelegatesToPredator() throws Exception {
        Predator predatorMock = Mockito.mock(Predator.class);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(predatorMock.eatMeat()).thenReturn(expected);
        Lion lion = new Lion("Самка", predatorMock);
        assertEquals(expected, lion.getFood());
    }
}
