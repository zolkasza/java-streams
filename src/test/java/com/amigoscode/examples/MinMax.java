package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class MinMax {

    @Test
    public void min() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
        Integer min1 = numbers.stream().min(((o1, o2) -> o1.compareTo(o2))).get();
        Integer min2 = numbers.stream().min((Integer::compareTo)).get();
        Integer min3 = numbers.stream().min((Comparator.naturalOrder())).get();
        System.out.println(min1);
        System.out.println(min2);
        System.out.println(min3);
    }

    @Test
    public void max() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
        Integer max1 = numbers.stream().max((o1, o2) -> o1.compareTo(o2)).get();
        Integer max2 = numbers.stream().max(Integer::compareTo).get();
        Integer max3 = numbers.stream().max(Comparator.naturalOrder()).get();
        System.out.println(max1);
        System.out.println(max2);
        System.out.println(max3);
    }
}
