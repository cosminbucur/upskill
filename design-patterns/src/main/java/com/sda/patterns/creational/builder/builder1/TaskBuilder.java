package com.sda.patterns.creational.builder.builder1;

import java.time.LocalDate;

public class TaskBuilder {

    public boolean done;
    private Long id;
    private String summary;
    private String description;
    private LocalDate dueDate;

    public TaskBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public TaskBuilder setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public TaskBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public TaskBuilder setDone(boolean done) {
        this.done = done;
        return this;
    }

    public TaskBuilder setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Task build() {
        return new Task(id, summary, description, done, dueDate);
    }
}
