package com.todo.ToDo.Application.model;

import com.fasterxml.jackson.annotation.*;
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
//    @JsonProperty
   private long id;
//    @JsonProperty
   private String title;
//    @JsonProperty
   private Date date;
//    @JsonProperty
   private String status;

}
