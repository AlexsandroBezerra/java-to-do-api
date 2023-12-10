package dev.alexsandrobezerra.todo.crudapi.controller;

import dev.alexsandrobezerra.todo.crudapi.model.Task;
import dev.alexsandrobezerra.todo.crudapi.model.dto.TaskRequestBody;
import dev.alexsandrobezerra.todo.crudapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> index() {
        return taskService.listAll();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> show(@PathVariable(name = "id") String id) {
        var taskId = Long.parseLong(id);
        var task = taskService.getById(taskId);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tasks")
    public ResponseEntity<Void> create(@RequestBody TaskRequestBody taskRequestBody) throws URISyntaxException {
        var id = taskService.create(taskRequestBody);
        var location = new URI("/tasks/" + id);
        return ResponseEntity.created(location).build();
    }

}
