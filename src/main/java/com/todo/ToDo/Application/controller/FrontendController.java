package com.todo.ToDo.Application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class FrontendController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/addTaskPage")
    public String addTaskPage() {
        return "addTask";
    }

    @GetMapping("/tasksPage")
    public String viewTasks(Model model) {
        model.addAttribute("tasks", new ArrayList<>()); // Replace with actual task data
        return "viewTasks";
    }
}
