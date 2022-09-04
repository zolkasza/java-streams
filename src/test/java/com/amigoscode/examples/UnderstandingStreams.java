package com.amigoscode.examples;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UnderstandingStreams {

    @Test
    void collect() throws IOException {
        List<String> emails = MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                //.collect(Collectors.toList()) igazából ez:
//                .collect(() -> new ArrayList<String>(),
//                        (list, element) -> list.add(element),
//                        (lsit1, list2) -> lsit1.addAll(list2));
                // egyszerűsítve:
//                .collect(
//                        ArrayList::new,
//                        ArrayList::add,
//                        ArrayList::addAll
//                );
                .collect(Collectors.toList());
        emails.forEach(System.out::println);
    }

    @Test
    public void lazy() throws Exception {
        System.out.println(
                MockData.getCars()
                        .stream()
                        .filter(car -> {
                            System.out.println("filter car " + car);
                            return car.getPrice() < 10000;
                        })
                        .map(car -> {
                            System.out.println("mapping car " + car);
                            return car.getPrice();
                        })
                        .map(price -> {
                            System.out.println("mapping price " + price);
                            return price + (price * .14);
                        })
                // csak akkor fut le ha van terminal operátor (pl collect)
                        .collect(Collectors.toList())
        );
    }
}
