package com.todo.ToDo.Application.mapper;

import com.todo.ToDo.Application.dtos.ToDoRequest;
import com.todo.ToDo.Application.dtos.ToDoResponse;
import com.todo.ToDo.Application.model.ToDo;
import org.springframework.stereotype.Component;

@Component
public class ToDoMapper {

    public   ToDo toEntity(ToDoRequest toDoRequest)
    {
        ToDo toDo=new ToDo();
        toDo.setTitle(toDoRequest.getTitle());
        toDo.setTitle(toDoRequest.getTitle());
        toDo.setDate(toDoRequest.getDate());
        toDo.setStatus(toDoRequest.getStatus());
        return toDo;
    }
    public  ToDoResponse toDoResponseDto(ToDo toDo)
    {
        ToDoResponse response=new ToDoResponse();
        response.setId(toDo.getId());
        response.setTitle(toDo.getTitle());
        response.setDate(toDo.getDate());
        response.setStatus(toDo.getStatus());
        return response;
    }
    public void updateEntityFromRequest(ToDoRequest toDoRequest, ToDo existingToDo) {
        existingToDo.setTitle(toDoRequest.getTitle());
        existingToDo.setDate(toDoRequest.getDate());
        existingToDo.setStatus(toDoRequest.getStatus());
    }
}
