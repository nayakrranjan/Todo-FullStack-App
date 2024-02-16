package com.app.todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;

@Entity(name = "todos")
public class Todo {

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    @Column(name = "task")
    private String task;

    @Column(name = "target_date")
    @FutureOrPresent
    private LocalDate targetDate;

    @Column(name = "done")
    private boolean done;

    public Todo(Integer id, String username, String task, LocalDate targetDate, boolean done) {
        this.id = id;
        this.username = username;
        this.task = task;
        this.targetDate = targetDate;
        this.done = done;
    }

    public Todo() {}

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", user=" + username +
                ", task='" + task + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}