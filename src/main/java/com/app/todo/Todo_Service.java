package com.app.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Service
public class Todo_Service {
    private static List<Todo> todos = new ArrayList<>();
    private static int todo_count = 0;

    static {
        todos.add(new Todo(++todo_count, "nayakrranjan", "task-1", LocalDate.now().plusDays(10), false));
        todos.add(new Todo(++todo_count, "nayakrranjan", "task-2", LocalDate.now().plusDays(12), false));
        todos.add(new Todo(++todo_count, "nayakrranjan", "task-3", LocalDate.now().plusDays(2), true));
        todos.add(new Todo(++todo_count, "nayakrranjan", "task-4", LocalDate.now().plusDays(21), false));
        todos.add(new Todo(++todo_count, "nayakrranjan", "task-5", LocalDate.now().plusDays(32), true));
    }

    public Todo addTodo(String username, String task, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todo_count, username, task, targetDate, done);
        todos.add(todo);
        return todo;
    }

    public List<Todo> getByUserName(String username) {
        return todos.stream().filter(todo -> todo.getUsername().equals(username)).toList();
    }

    public Todo findById(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
    }

    public void deleteById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo updateById(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
        return todo;
    }
}
