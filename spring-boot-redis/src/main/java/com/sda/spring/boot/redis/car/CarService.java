package com.sda.spring.boot.redis.car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = {"cars"})
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

    @Cacheable(key = "#id")
    @Override
    public Car findById(Long id) {
        log.info("find by id: {}", id);
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("car not found"));
    }

    // unless - return value
    @Cacheable(unless = "#owner == 'cristi'")
    @Override
    public Car findByOwner(String owner) {
        log.info("find by owner: {}", owner);
        return carRepository.findByOwner(owner);
    }

    // condition - return list
    @Cacheable(condition = "#brand == 'bmw'")
    @Override
    public List<Car> findByBrand(String brand) {
        log.info("find by brand: {}", brand);
        return carRepository.findByBrand(brand);
    }

    @CachePut(key = "#id")
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

    @CacheEvict(key = "#id")
    @Override
    public void delete(Long id) {
        log.info("delete by id: {}", id);
        carRepository.deleteById(id);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void clearCache() {
        log.info("clearing cache");
    }
}
