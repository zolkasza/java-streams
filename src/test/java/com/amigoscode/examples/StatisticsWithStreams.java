package com.amigoscode.examples;


import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class StatisticsWithStreams {

    @Test
    public void count() throws Exception {
        List<Car> cars = MockData.getCars();
        long count = cars.stream()
                .filter(car -> car.getMake().equalsIgnoreCase("Ford"))
                .count();
        System.out.println(count);
    }

    @Test
    public void min() throws Exception {
        List<Car> cars = MockData.getCars();
        double min = cars.stream()
                .mapToDouble(Car::getPrice)
                .min()
                .orElse(0);
        System.out.println(min);
    }

    @Test
    public void max() throws Exception {
        List<Car> cars = MockData.getCars();
        double max = cars.stream()
                .mapToDouble(Car::getPrice)
                .max()
                .orElse(0);
        System.out.println(max);
    }


    @Test
    public void average() throws Exception {
        List<Car> cars = MockData.getCars();
        double avg = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println(avg);
    }

    @Test
    public void sum() throws Exception {
        List<Car> cars = MockData.getCars();
        double sum = cars.stream()
                .mapToDouble(Car::getPrice)
                .sum();
        System.out.println(BigDecimal.valueOf(sum));
    }

    @Test
    public void statistics() throws Exception {
        List<Car> cars = MockData.getCars();
        DoubleSummaryStatistics stats = cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();
        System.out.println(stats.getCount());
        System.out.println(stats.getMin());
        System.out.println(stats.getMax());
        System.out.println(stats.getAverage());
        System.out.println(BigDecimal.valueOf(stats.getSum()));
    }

}