package com.todo.ToDo.Application.service;


import com.todo.ToDo.Application.dtos.ToDoRequest;
import com.todo.ToDo.Application.dtos.ToDoResponse;
import com.todo.ToDo.Application.model.ToDo;
import com.todo.ToDo.Application.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@AllArgsConstructor
public class ToDoService {

   private final ToDoRepository repo;

    public ToDoService(ToDoRepository repo) {
        this.repo = repo;
    }

    public List<ToDoResponse> getAllToDoTasks() {
        ArrayList<ToDoResponse> todoList = new ArrayList<>();
        repo.findAll().forEach(toDo ->{
            ToDoResponse response=ToDoResponse.builder()
                    .id(toDo.getId())
                    .title(toDo.getTitle())
                    .status(toDo.getStatus())
                    .date(toDo.getDate())
                    .build();
                    todoList.add(response);
        });
        return todoList;
    }

    public ToDoResponse getAllToDoTasksById(Long id) {
        ToDo toDo = repo.findById(id).orElse(null);
        if (toDo == null) {
            throw new RuntimeException("ToDo not found for id: " + id);
        }

        return ToDoResponse.builder()
                .id(toDo.getId())
                .title(toDo.getTitle())
                .status(toDo.getStatus())
                .date(toDo.getDate())
                .build();
    }


    public ToDoResponse updateToDoTask(Long id,ToDoRequest updateToDoRequest ) {
        ToDo existingTask=repo.findById(id).orElse(null);
        if(existingTask==null){
            return ToDoResponse.builder().message("No task is found with this id").build();
        }
       existingTask.setTitle(updateToDoRequest.getTitle());
        existingTask.setStatus(updateToDoRequest.getStatus());
        existingTask.setDate(updateToDoRequest.getDate());
        repo.save(existingTask);
        return ToDoResponse.builder()
                .id(existingTask.getId())
                .title(existingTask.getTitle())
                .date(existingTask.getDate())
                .status(existingTask.getStatus())
                .message("Task with id "+id+" update sucessfully")
                .build();

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
        ToDo toDo=new ToDo();
        toDo.setTitle(toDoRequest.getTitle());
        toDo.setStatus(toDoRequest.getStatus());
        toDo.setDate(toDoRequest.getDate());
        repo.save(toDo);
        ToDoResponse response=new ToDoResponse();
        response.setTitle(toDo.getTitle());
        response.setStatus(toDo.getStatus());
        response.setDate(toDo.getDate());
        response.setId(toDo.getId());
        response.setMessage("Task added Sucessfully");
        return response;

}


}
