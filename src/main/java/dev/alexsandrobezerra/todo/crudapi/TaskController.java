package dev.alexsandrobezerra.todo.crudapi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class TaskController {

    private final TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> index() {
        return taskRepository.findAll();
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> create(@RequestBody TaskRequestBody taskRequestBody) {
        var task = taskRequestBody.toModel();
        taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

}
