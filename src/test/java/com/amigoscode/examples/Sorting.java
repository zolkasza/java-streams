package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sorting {

    @Test
    public void sortingSteamOfElements() throws IOException {
        List<Person> people = MockData.getPeople();
        List<String> sorted = people.stream()
                .map(Person::getFirstName)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sorted);
    }

    @Test
    public void sortingSteamOfElementsReverse() throws IOException {
        List<Person> people = MockData.getPeople();
        List<String> reverse = people.stream()
                .map(Person::getFirstName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(reverse);
    }

    @Test
    public void sortingSteamOfObjets() throws IOException {
        List<Person> people = MockData.getPeople();
//        // lehet láncolni és több minden alapján rendezni
//        Comparator<Person> comparing = Comparator
//                .comparing(Person::getFirstName)
//                .thenComparing(Person::getEmail);
//        Comparator<Person> comparingRev = Comparator
//                .comparing(Person::getFirstName)
//                .reversed();
//        List<Person> sorted = people.stream()
//                .sorted(comparing)
//                .collect(Collectors.toList());
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
    }

    @Test
    public void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> cars = MockData.getCars();
        Comparator<Car> comparing = Comparator.comparing(Car::getPrice).reversed();
        List<Car> result = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("blue"))
                .sorted(comparing)
                .limit(10)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

}
