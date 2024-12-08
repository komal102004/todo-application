package com.todo.ToDo.Application.service;


import com.todo.ToDo.Application.model.ToDo;
import com.todo.ToDo.Application.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class ToDoService {

   private final ToDoRepository repo;

    public ToDoService(ToDoRepository repo) {
        this.repo = repo;
    }

    public List<ToDo> getAllToDoTasks() {
        ArrayList<ToDo> todoList = new ArrayList<>();
        repo.findAll().forEach(toDo -> todoList.add(toDo));
        return todoList;
    }

    public ToDo getAllToDoTasksById(Long id) {
        return repo.findById(id).get();
    }


    public boolean updateToDoTask(Long id, ToDo todo) {
        ToDo existingTask=repo.findById(id).orElse(null);
        if(existingTask==null){
            return false;
        }
        existingTask.setTitle(todo.getTitle());
        existingTask.setStatus(todo.getStatus());
        existingTask.setDate(todo.getDate());
        repo.save(existingTask);
        return true;
    }

    public boolean deleteToDoTask(Long id) {
        ToDo todo = repo.findById(id).orElse(null);
        if (todo == null) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }


    public String createTask(ToDo todo) {
        repo.save(todo);
        return "Task added Sucessfully" + todo.getId();
    }
}
