package com.todo.ToDo.Application.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="work_tbl")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
    @Column
   private String title;
   private Date date;
   private String status;

}
