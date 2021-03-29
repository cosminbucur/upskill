package com.sda.spring.boot.redis.car;


import com.sda.spring.boot.redis.car.persistence.Car;

import java.util.List;

public interface ICarService {

    Car save(Car car);

    List<Car> findAll();

    Car findById(Long id);

    Car findByOwner(String owner);

    Car update(Long id, Car updateInfo);

    void delete(Long id);
}
