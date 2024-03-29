package dev.alexsandrobezerra.todo.crudapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

}
