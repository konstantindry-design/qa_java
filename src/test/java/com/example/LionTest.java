package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean expectedHasMane;

    public LionTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Пол: {0}, есть грива: {1}")
    public static Object[][] hasManeData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveManeDependsOnSex() throws Exception {
        Lion lion = new Lion(sex, Mockito.mock(Predator.class));
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

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

