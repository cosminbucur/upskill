package com.sda.spring.boot.redis.car;

import com.sda.spring.boot.redis.car.persistence.Car;
import com.sda.spring.boot.redis.car.persistence.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService {

    private static final Logger log = LoggerFactory.getLogger(CarService.class);

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car save(Car car) {
        log.info("saving car: {}", car);
        return carRepository.save(car);
    }

    @Override
    public List<Car> findAll() {
        log.info("find all from db");
        return carRepository.findAll();
    }

    @Override
    public Car findById(Long id) {
        log.info("find by id: {}", id);
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("car not found"));
    }

    @Override
    public Car findByOwner(String owner) {
        log.info("find by owner: {}", owner);
        return carRepository.findByOwner(owner);
    }

    @Override
    public Car update(Long id, Car updateInfo) {
        log.info("updating car id: {}, with data: {}", id, updateInfo);

        // find car
        return carRepository.findById(id)
                .map(car -> {
                    // update info
                    car.setOwner(updateInfo.getOwner());
                    car.setBrand(updateInfo.getBrand());
                    car.setModel(updateInfo.getModel());
                    car.setPrice(updateInfo.getPrice());

                    return carRepository.save(car);
                    // save
                })
                .orElseThrow(() -> new RuntimeException("car not found"));
    }

    @Override
    public void delete(Long id) {
        log.info("delete by id: {}", id);
        carRepository.deleteById(id);
    }
}
