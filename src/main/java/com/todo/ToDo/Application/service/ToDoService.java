package com.todo.ToDo.Application.service;


import com.todo.ToDo.Application.mapper.ToDoMapper;
import com.todo.ToDo.Application.dtos.ToDoRequest;
import com.todo.ToDo.Application.dtos.ToDoResponse;
import com.todo.ToDo.Application.model.ToDo;
import com.todo.ToDo.Application.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
//@AllArgsConstructor
public class ToDoService {

   private final ToDoRepository repo;
   private final ToDoMapper toDoMapper;

    public ToDoService(ToDoRepository repo, ToDoMapper toDoMapper) {
        this.repo = repo;
        this.toDoMapper = toDoMapper;
    }

    public List<ToDoResponse> getAllToDoTasks() {
        ArrayList<ToDoResponse> todoList = new ArrayList<>();
        repo.findAll().forEach(toDo ->{
            ToDoResponse response=toDoMapper.toDoResponseDto(toDo);
            response.setMessage("Task with id " + id + " updated successfully");
            todoList.add(response);
        });
        return todoList;
    }

    public ToDoResponse getAllToDoTasksById(Long id) {

        ToDo toDo = repo.findById(id).orElse(null);
        if (toDo == null) {
            throw new RuntimeException("ToDo not found for id: " + id);
        }

        ToDoResponse response=toDoMapper.toDoResponseDto(toDo);
        response.setMessage("Task with id " + id + " updated successfully");
        return response;

    }


    public ToDoResponse updateToDoTask(Long id,ToDoRequest updateToDoRequest ) {

        ToDo existingTask=repo.findById(id).orElse(null);
        if(existingTask==null){
            return ToDoResponse.builder().message("No task is found with this id").build();
        }

        toDoMapper.updateEntityFromRequest(updateToDoRequest, existingTask);
        repo.save(existingTask);
       ToDoResponse response=toDoMapper.toDoResponseDto(existingTask);
       response.setMessage("Task with id " + id + " updated successfully");
       return response;

    }

    public boolean deleteToDoTask(Long id) {
        ToDo todo = repo.findById(id).orElse(null);
        if (todo == null) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }
    public ToDoResponse createTask(ToDoRequest toDoRequest) {

        ToDo toDo=toDoMapper.toEntity(toDoRequest);
        repo.save(toDo);
        ToDoResponse response=toDoMapper.toDoResponseDto(toDo);
        response.setMessage("Task added Sucessfully");
        return response;

}


}
