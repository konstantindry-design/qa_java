package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class FelineTest {

    private final String animalKind;
    private final List<String> expectedFood;

    public FelineTest(String animalKind, List<String> expectedFood) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters(name = "Вид: {0}")
    public static Object[][] getFoodData() {
        return new Object[][]{
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Травоядное", List.of("Трава", "Различные растения")}
        };
    }

    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        Feline feline = new Feline();
        assertEquals(expectedFood, feline.getFood(animalKind));
    }

    @Test
    public void getFoodUnknownKindThrowsException() {
        Feline feline = new Feline();
        Exception exception = assertThrows(Exception.class,
                () -> feline.getFood("Всеядное"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }

    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        Feline feline = new Feline();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyReturnsFeline() {
        assertEquals("Кошачьи", new Feline().getFamily());
    }

    @Test
    public void getKittensWithoutArgsReturnsOne() {
        assertEquals(1, new Feline().getKittens());
    }

    @Test
    public void getKittensWithArgsReturnsSameCount() {
        assertEquals(5, new Feline().getKittens(5));
    }
}

