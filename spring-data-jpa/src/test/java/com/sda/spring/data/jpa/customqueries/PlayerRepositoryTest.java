package com.sda.spring.data.jpa.customqueries;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.ZonedDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PlayerRepositoryTest {

    public static final String PLAYER_NAME_PAUL = "paul";
    public static final String PLAYER_NAME_ANNA = "anna";
    public static final ZonedDateTime BIRTHDATE = ZonedDateTime.now();

    @Autowired
    private PlayerRepository repository;

    @BeforeEach
    void setUp() {
        Player player1 = new Player(PLAYER_NAME_PAUL, 25, BIRTHDATE, true);
        Player player2 = new Player(PLAYER_NAME_PAUL, 20, BIRTHDATE, false);
        Player player3 = new Player(PLAYER_NAME_ANNA, 20, BIRTHDATE, true);
        Player player4 = new Player(null, 30, BIRTHDATE, false);

        repository.saveAll(Arrays.asList(player1, player2, player3, player4));
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void findByName_shouldReturnCorrectResult() {
        assertThat(repository.findByName(PLAYER_NAME_PAUL)).hasSize(2);
    }

    @Test
    void findByNameIsNull_shouldReturnCorrectResult() {
        assertThat(repository.findByNameIsNull()).hasSize(1);
    }

    @Test
    void findByNameNot_shouldReturnCorrectResult() {
        assertThat(repository.findByNameNot(PLAYER_NAME_PAUL).get(0).getName())
                .isEqualTo(PLAYER_NAME_ANNA);
    }

    @Test
    void findByNameStartingWith_shouldReturnCorrectResult() {
        assertThat(repository.findByNameStartingWith("a")).hasSize(1);
    }

    @Test
    void findByNameLike_shouldReturnCorrectResult() {
        assertThat(repository.findByNameLike("ul")).hasSize(2);
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
        assertThat(repository.findByNameOrderByNameDesc(PLAYER_NAME_PAUL)).hasSize(2);
    }

    @Test
    void updateName_shouldReturnCorrectResult() {
        assertThat(repository.updateName("test", true)).isEqualTo(2);
    }

    @Test
    void deleteByName_shouldReturnCorrectResult() {
        assertThat(repository.deleteByName(PLAYER_NAME_PAUL)).isEqualTo(2);
    }
}