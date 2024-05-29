package web.controller;

import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarDealer {

    private final List<Car> cars = new ArrayList<>();

    public CarDealer() {
        cars.addAll(Arrays.asList(
                new Car("Volvo", "S90", 2005),
                new Car("Volga", "H50", 2023),
                new Car("Lada", "2107", 1999),
                new Car("Chevrolet", "Niva", 2002),
                new Car("BWM", "X6", 2023),
                new Car("Hyundai", "Solaris", 2024)
        ));
    }

    public List<Car> getCarsFromDealer(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
