package com.wellsfargointerview.danbury.restservice;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TaskController {

    private final TaskRepository repository;

    TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/tasks")
    List<Task> all() {
        return repository.findAll();
    }

    @PostMapping("/tasks")
    Task newEmployee(@RequestBody Task newTask) {
        return repository.save(newTask);
    }

    // Single item

    @GetMapping("/tasks/{id}")
    Task one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @PutMapping("/tasks/{id}")
    Task replaceTask(@RequestBody Task newTask, @PathVariable Long id) {

        return repository.findById(id)
                .map(task -> {
                    task.setTaskName(newTask.getTaskName());
                    task.setRole(newTask.getRole());
                    task.setCreateDate(newTask.getCreateDate());
                    return repository.save(task);
                })
                .orElseGet(() -> {
                    newTask.setId(id);
                    return repository.save(newTask);
                });
    }

    @DeleteMapping("/tasks/{id}")
    void deleteTask(@PathVariable Long id) {
        repository.deleteById(id);
    }
}