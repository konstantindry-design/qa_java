package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FelineCommonTest {

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
