package com.app.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Todo_Controller {
    TodoRepository todoRepository;

    public Todo_Controller(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/auth")
    public String authCheck() {
        return "Success";
    }
    @GetMapping("/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username) {
        return todoRepository.findByUsername(username);
    }

    @GetMapping("{username}/todos/{id}")
    public Todo getTodoById(@PathVariable String username, @PathVariable int id) {
        return todoRepository.findById(id).get();
    }

    @DeleteMapping("{username}/todos/{id}")
    public ResponseEntity<Void> removeTodoById(@PathVariable String username, @PathVariable int id) {
        todoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{username}/todos/{id}")
    public Todo updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
        todo.setId(id);
        todo.setUsername(username);
        todoRepository.save(todo);
        return todo;
    }

    @PostMapping("{username}/todos")
    public Todo createTodo(@PathVariable String username, @RequestBody Todo todo) {
        todo.setUsername(username);
        todo.setId(null);
        return todoRepository.save(todo);
    }
}
