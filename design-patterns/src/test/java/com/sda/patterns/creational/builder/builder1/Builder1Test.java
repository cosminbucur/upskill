package com.sda.patterns.creational.builder.builder1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class Builder1Test {

    @Test
    void createTask() {
        Task expectedTask = new Task(
                1L,
                "summary",
                "description",
                true,
                LocalDate.of(2021, 3, 21)
        );

        Task actualTask = new TaskBuilder()
                .setId(1L)
                .setDescription("description")
                .setSummary("summary")
                .setDueDate(LocalDate.of(2021, 3, 21))
                .setDone(true)
                .build();

        assertThat(actualTask).isEqualTo(expectedTask);
    }

}