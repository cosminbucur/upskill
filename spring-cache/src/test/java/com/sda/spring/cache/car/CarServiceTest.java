package com.sda.spring.cache.car;

import com.sda.spring.cache.car.persistence.Car;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// TODO: use cache manager
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class CarServiceTest {

    @Autowired
    private CarService carService;

    @Order(1)
    @Test
    void findAll() {
        // given
        carService.save(new Car("owner1", "audi", "a4", 20000));
        carService.save(new Car("owner2", "bmw", "x1", 30000));
        carService.save(new Car("owner3", "dacia", "duster", 16000));

        // when
        carService.findAll();
        List<Car> actual = carService.findAll();

        // then
        assertThat(actual).hasSize(3);
    }

    @Order(2)
    @Test
    void findById() {
        // given
        carService.save(new Car("owner4", "audi", "a4", 20000));
        Car bmw = carService.save(new Car("owner5", "bmw", "x1", 30000));

        // when
        carService.findById(bmw.getId());
        Car actual = carService.findById(bmw.getId());

        // then
        assertThat(actual).isNotNull();
    }

    @Order(3)
    @Test
    void update() {
        // given
        Car bmw = carService.save(new Car("owner6", "bmw", "x1", 30000));
        Car updateData = new Car("owner7", "bmw", "x5", 40000);

        // when
        Car actual = carService.update(bmw.getId(), updateData);

        // then
        assertThat(actual.getModel()).isEqualTo(updateData.getModel());
        assertThat(actual.getPrice()).isEqualTo(updateData.getPrice());
    }

    @Order(4)
    @Test
    void delete() {
        // given
        carService.save(new Car("owner8", "audi", "a4", 20000));
        Car bmw = carService.save(new Car("owner9", "bmw", "x1", 30000));

        // when
        carService.delete(bmw.getId());

        // should have no entry in cache
        // then
        assertThat(carService.findAll()).hasSize(3);
    }
}