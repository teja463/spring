package com.example.todo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public List<Todo> getAll() {
        return this.todoRepository.findAll();
    }

    @PostMapping
    public Todo add(@RequestBody Todo todo) {
        return this.todoRepository.save(todo);
    }

    @PutMapping
    public Todo update(@RequestBody Todo todo) throws InterruptedException {
        Todo t = this.todoRepository.findById(todo.getId()).orElseThrow(() -> new RuntimeException("ID Not found"));
        t.setText(todo.getText());
        return this.todoRepository.save(t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.todoRepository.deleteById(id);
    }
}
