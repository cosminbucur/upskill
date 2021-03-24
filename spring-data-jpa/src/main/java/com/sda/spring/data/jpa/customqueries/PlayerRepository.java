package com.sda.spring.data.jpa.customqueries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    // custom queries

    // find by
    List<Player> findByName(String name);

    List<Player> findByNameIs(String name);

    List<Player> findByNameEquals(String name);

    List<Player> findByNameIsNull();

    List<Player> findByNameNot(String name);

    List<Player> findByNameIsNot(String name);

    List<Player> findByNameStartingWith(String name);

    List<Player> findByNameEndingWith(String name);

    List<Player> findByNameContaining(String name);

    @Query("SELECT p FROM Player p WHERE p.name LIKE %:name%")
    List<Player> findByNameLike(@Param("name") String name);

    // find by numbers

    List<Player> findByAgeLessThan(Integer age);

    List<Player> findByAgeLessThanEqual(Integer age);

    List<Player> findByAgeGreaterThan(Integer age);

    List<Player> findByAgeGreaterThanEqual(Integer age);

    List<Player> findByAgeBetween(Integer minAge, Integer maxAge);

    List<Player> findByAgeIn(Collection<Integer> ages);

    // find by dates

    List<Player> findByBirthdateBefore(ZonedDateTime birthdate);

    List<Player> findByBirthdateAfter(ZonedDateTime birthdate);

    // boolean

    List<Player> findByActiveTrue();

    List<Player> findByActiveFalse();

    // find by or

    List<Player> findByNameOrBirthdate(String name, ZonedDateTime birthdate);

    List<Player> findByNameOrBirthdateAndActive(String name, ZonedDateTime birthdate, Boolean active);

    // find by order

    List<Player> findByNameOrderByName(String name);

    List<Player> findByNameOrderByNameDesc(String name);

    // must use native query for update
    @Modifying
    @Query(value = "UPDATE player SET name = :name WHERE active = :active", nativeQuery = true)
    int updateName(@Param("name") String name, @Param("active") boolean active);

    @Modifying
    @Query(value = "DELETE FROM Player WHERE name = :name")
    int deleteByName(@Param("name") String name);


}
