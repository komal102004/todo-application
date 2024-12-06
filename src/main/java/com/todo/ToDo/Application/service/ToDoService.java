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

    public List<ToDo> getAllToDoTasks()
{
  ArrayList<ToDo> todoList =new ArrayList<>();
  repo.findAll().forEach(toDo -> todoList.add(toDo));
  return todoList;
}
public ToDo getAllToDoTasksById(Long id)
{
    return repo.findById(id).get();
}
public boolean updateStatus(Long id)
{
    ToDo todo=getAllToDoTasksById(id);

    return saveOrUpdateToDoTask(id, todo);
}
public boolean saveOrUpdateToDoTask(Long id, ToDo todo)
{
    repo.save(todo);
    if(getAllToDoTasksById(todo.getId())!=null)
    {
        return true;
    }
    return false;
}
public boolean deleteToDoTask(Long id)
{
    ToDo todo=repo.findById(id).orElse(null);
//    Optional<ToDo> todo1=repo.findById(id);

    if(todo==null){
        return false;
    }
    repo.deleteById(id);
    return true;
}


    public String createTask(ToDo todo ) {
    repo.save(todo);
    return "Task added Sucessfully"+todo.getId();
    }
}
