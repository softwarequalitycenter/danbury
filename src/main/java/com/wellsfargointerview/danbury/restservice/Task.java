package com.wellsfargointerview.danbury.restservice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
class Task {

    private @Id @GeneratedValue Long id;
    private String taskName;
    private LocalDate createDate;
    private String role;


    Task() {}

    Task(String name, String role, LocalDate createDate) {
        this.taskName = name;
        this.createDate = createDate;
        this.role = role;

    }
}