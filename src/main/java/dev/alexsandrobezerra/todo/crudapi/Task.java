package dev.alexsandrobezerra.todo.crudapi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    Task(String title) {
        this.title = title;
    }

}
