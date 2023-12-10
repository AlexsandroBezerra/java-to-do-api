package dev.alexsandrobezerra.todo.crudapi;

public record TaskRequestBody(String title) {

    public Task toModel() {
        return new Task(title);
    }

}
