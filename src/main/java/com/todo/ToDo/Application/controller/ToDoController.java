package com.todo.ToDo.Application.controller;

import com.todo.ToDo.Application.model.*;
import com.todo.ToDo.Application.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ToDoController {

    private final ToDoService service;

    public ToDoController(ToDoService service) {
        this.service = service;
    }

    @PostMapping("/addTask")
    public String addTask(@RequestBody ToDo task) {
        return service.createTask(task);
    }

    @GetMapping("/tasks")
    public List<ToDo> findAllTasks() {
        return service.getAllToDoTasks();
    }

    @GetMapping("/task/{id}")
    public ToDo findProductByID(@PathVariable("id") Long id) {
        return service.getAllToDoTasksById(id);
    }

    @PutMapping("/updateTask/{id}")
    public boolean updateproductsById(@PathVariable Long id, @RequestBody ToDo tasks) {
        return service.updateToDoTask(id, tasks);
    }

    @DeleteMapping("/deleteTask/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        return service.deleteToDoTask(id);
    }



}
