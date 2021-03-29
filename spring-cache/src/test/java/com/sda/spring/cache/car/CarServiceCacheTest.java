package com.sda.spring.cache.car;

import com.sda.spring.cache.car.persistence.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CarServiceCacheTest {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private CarService carService;

    @Test
    void whenAnyOtherOwnerThanCristi_shouldCacheResult() {
        // given
        carService.save(new Car("bianca", "audi", "a4", 2000));
        carService.save(new Car("cristi", "dacia", "duster", 1600));

        // when
        Car carOfBianca = carService.findByOwner("bianca");

        Cache carsCache = cacheManager.getCache("cars");
        Car cachedCar = carsCache.get("bianca", Car.class);

        // then
        // one car in cache
        assertThat(carOfBianca).isEqualTo(cachedCar);
    }

    @Test
    void whenOwnerIsCristi_shouldNotCacheResult() {
        // given
        carService.save(new Car("bianca", "audi", "a4", 2000));
        carService.save(new Car("cristi", "dacia", "duster", 1600));

        // when
        Car carOfCristi = carService.findByOwner("cristi");

        Cache carsCache = cacheManager.getCache("cars");
        Car nullCar = carsCache.get("cristi", Car.class);

        // then
        assertThat(nullCar).isNull();
    }
}
