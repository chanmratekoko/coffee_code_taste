package com.cmkk.streamsvsloops;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamsVsLoopsUnitTest {

    @Test
    public void givenListWithFruits_whenFilterUsingStream_thenReturnedCount() {
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape");
        long count = fruits.stream()
                .filter(fruit -> fruit.length() > 5)
                .count();
        assertEquals(2, count);
    }

    @Test
    public void givenListWithFruits_whenFilterUsingForLoop_thenReturnedCount() {
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape");
        long count = 0; for (String fruit : fruits) {
            if (fruit.length() > 5) {
                count++;
            }
        }
        assertEquals(2, count);
    }

    @Test
    public void givenListWithFruits_whenApplyUppercase_thenNewListGenerated() {
        List<String> desiredArray = new ArrayList<>(Arrays.asList("APPLE", "BANANA", "ORANGE"));
        List<String> fruits = new ArrayList<>(Arrays.asList("apple", "banana", "orange"));
        List<String> upperCaseFruits = fruits.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        assertEquals(desiredArray, upperCaseFruits);
    }

    @Test
    public void givenListWithFruits_whenApplyUppercase_elementsAreUpdated() {
        List<String> desiredArray = new ArrayList<>(Arrays.asList("APPLE", "BANANA", "ORANGE"));
        List<String> fruits = new ArrayList<>(Arrays.asList("apple", "banana", "orange"));
        for (int i = 0; i < fruits.size(); i++) {
            fruits.set(i, fruits.get(i).toUpperCase());
        }
        assertEquals(desiredArray, fruits);
    }
}
