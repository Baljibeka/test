package com.example.test.service;

import com.example.test.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAllTasks();
    Optional<Task> findByIdTask(Long id);
    Task createTask(Task task);
    void deleteTask(long id);
    void updateTask(long id,Task task);
}
