package dev.alexsandrobezerra.todo.crudapi.service;

import dev.alexsandrobezerra.todo.crudapi.model.Task;
import dev.alexsandrobezerra.todo.crudapi.model.dto.TaskRequestBody;
import dev.alexsandrobezerra.todo.crudapi.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    public List<Task> listAll() {
        return taskRepository.findAll();
    }

    public long create(TaskRequestBody taskRequestBody) {
        var task = modelMapper.map(taskRequestBody, Task.class);
        taskRepository.save(task);
        return task.getId();
    }

    public Optional<Task> getById(long id) {
        return taskRepository.findById(id);
    }
}
