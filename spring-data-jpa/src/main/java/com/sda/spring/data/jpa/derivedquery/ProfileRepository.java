package com.sda.spring.data.jpa.derivedquery;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    // derived queries

    // find by
    List<Profile> findByName(String name);

    List<Profile> findByNameIs(String name);

    List<Profile> findByNameEquals(String name);

    List<Profile> findByNameIsNull();

    List<Profile> findByNameNot(String name);

    List<Profile> findByNameIsNot(String name);

    List<Profile> findByNameStartingWith(String name);

    List<Profile> findByNameEndingWith(String name);

    List<Profile> findByNameContaining(String name);

    List<Profile> findByNameLike(String name);

    // find by numbers

    List<Profile> findByAgeLessThan(Integer age);

    List<Profile> findByAgeLessThanEqual(Integer age);

    List<Profile> findByAgeGreaterThan(Integer age);

    List<Profile> findByAgeGreaterThanEqual(Integer age);

    List<Profile> findByAgeBetween(Integer minAge, Integer maxAge);

    List<Profile> findByAgeIn(Collection<Integer> ages);

    // find by dates

    List<Profile> findByBirthdateBefore(ZonedDateTime birthdate);

    List<Profile> findByBirthdateAfter(ZonedDateTime birthdate);

    // boolean

    List<Profile> findByActiveTrue();

    List<Profile> findByActiveFalse();

    // find by or

    List<Profile> findByNameOrBirthdate(String name, ZonedDateTime birthdate);

    List<Profile> findByNameOrBirthdateAndActive(String name, ZonedDateTime birthdate, Boolean active);

    // find by order

    List<Profile> findByNameOrderByName(String name);

    List<Profile> findByNameOrderByNameDesc(String name);
}
