package com.amigoscode.examples;


import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreams {

    @Test
    public void range() throws Exception {
        System.out.println("with for");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("with int stream exclusive");
        IntStream.range(0, 10).forEach(value -> System.out.println(value));
        System.out.println("with int stream inclusive");
        IntStream.rangeClosed(0, 10).forEach(value -> System.out.println(value));
    }

    // Loop through people using IntStream
    @Test
    public void rangeIteratingLists() throws Exception {
        List<Person> people = MockData.getPeople();
        IntStream.range(0, people.size())
                .limit(10)
                .forEach(index -> System.out.println(people.get(index)));
    }

    @Test
    public void intStreamIterate()  {
        // inUnaryOperator adja meg, hogy hogyan növelje az értéket
        IntStream.iterate(0, value -> value + 1)
                .limit(10)
                .forEach(System.out::println);
    }

    // LongStream, DoubleStream

}
