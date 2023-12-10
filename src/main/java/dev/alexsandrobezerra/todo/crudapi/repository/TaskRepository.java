package dev.alexsandrobezerra.todo.crudapi.repository;

import dev.alexsandrobezerra.todo.crudapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> { }
