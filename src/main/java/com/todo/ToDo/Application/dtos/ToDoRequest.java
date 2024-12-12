package com.todo.ToDo.Application.dtos;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class ToDoRequest {
    private String title;
    private Date date;
    private String status;
    private String message;
}
