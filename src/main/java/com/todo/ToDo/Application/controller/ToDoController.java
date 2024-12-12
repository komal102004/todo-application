package com.todo.ToDo.Application.controller;

import com.todo.ToDo.Application.dtos.ToDoRequest;
import com.todo.ToDo.Application.dtos.ToDoResponse;
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
    public ToDoResponse addTask(@RequestBody ToDoRequest toDoRequest) {
        return service.createTask(toDoRequest);
}
//    @PostMapping("/addTask")
//    public String addTask(@RequestBody ToDo task) {
//        return service.createTask(task);
//    }

    @GetMapping("/tasks")
    public List<ToDoResponse> findAllTasks() {
        return service.getAllToDoTasks();
    }

    @GetMapping("/task/{id}")
    public ToDoResponse findProductByID(@PathVariable("id") Long id) {
        return service.getAllToDoTasksById(id);
    }

    @PutMapping("/updateTask/{id}")
    public ToDoResponse updateproductsById(@PathVariable Long id, @RequestBody ToDoRequest toDoRequest) {
        return service.updateToDoTask(id, toDoRequest);
    }

    @DeleteMapping("/deleteTask/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        return service.deleteToDoTask(id);
    }



}
