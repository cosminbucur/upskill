package com.sda.spring.data.jpa.derivedquery;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.ZonedDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest(classes = DerivedQueryApplication.class)
@DataJpaTest
class ProfileRepositoryTest {

    public static final String PROFILE_NAME_PAUL = "paul";
    public static final String PROFILE_NAME_ANNA = "anna";
    public static final ZonedDateTime BIRTHDATE = ZonedDateTime.now();

    @Autowired
    private ProfileRepository repository;

    @BeforeEach
    void setUp() {
        Profile profile1 = new Profile(PROFILE_NAME_PAUL, 25, BIRTHDATE, true);
        Profile profile2 = new Profile(PROFILE_NAME_PAUL, 20, BIRTHDATE, false);
        Profile profile3 = new Profile(PROFILE_NAME_ANNA, 20, BIRTHDATE, true);
        Profile profile4 = new Profile(null, 30, BIRTHDATE, false);

        repository.saveAll(Arrays.asList(profile1, profile2, profile3, profile4));
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void findByName_shouldReturnCorrectResult() {
        assertThat(repository.findByName(PROFILE_NAME_PAUL)).hasSize(2);
    }

    @Test
    void findByNameIsNull_shouldReturnCorrectResult() {
        assertThat(repository.findByNameIsNull()).hasSize(1);
    }

    @Test
    void findByNameNot_shouldReturnCorrectResult() {
        assertThat(repository.findByNameNot(PROFILE_NAME_PAUL).get(0).getName())
                .isEqualTo(PROFILE_NAME_ANNA);
    }

    @Test
    void findByNameStartingWith_shouldReturnCorrectResult() {
        assertThat(repository.findByNameStartingWith("a")).hasSize(1);
    }

    @Test
    void findByAgeLessThan_shouldReturnCorrectResult() {
        assertThat(repository.findByAgeLessThan(25)).hasSize(2);
    }

    @Test
    void findByBirthdateAfter_shouldReturnCorrectResult() {
        ZonedDateTime yesterday = BIRTHDATE.minusDays(1);
        assertThat(repository.findByBirthdateAfter(yesterday)).hasSize(4);
    }

    @Test
    void findByActiveTrue_shouldReturnCorrectResult() {
        assertThat(repository.findByActiveTrue()).hasSize(2);
    }

    @Test
    void findByNameOrderByNameDesc_shouldReturnCorrectResult() {
        assertThat(repository.findByNameOrderByNameDesc(PROFILE_NAME_PAUL)).hasSize(2);
    }


}