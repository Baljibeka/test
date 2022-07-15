package com.example.test.service.impl;

import com.example.test.model.Task;
import com.example.test.repo.TaskRepository;
import com.example.test.service.TaskService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskrepo;

    public TaskServiceImpl(TaskRepository taskrepo) {
        super();
        this.taskrepo = taskrepo;
    }


    @Override
    public List<Task> findAllTasks() {
        return taskrepo.findAll();
    }

    @Override
    public Optional<Task> findByIdTask(Long id) {
        return taskrepo.findById(id);
    }

    @Override
    public Task createTask(Task task) {
        return taskrepo.save(task);
    }

    @Override
    public void deleteTask(long id) {
        taskrepo.deleteById(id);
    }

    @Override
    public void updateTask(long id, Task task) {
        Task existingTask= null;
        try {
            existingTask = taskrepo.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
            existingTask.setName(task.getName());
            existingTask.setDescription(task.getDescription());
            taskrepo.save(task);
        } catch (ChangeSetPersister.NotFoundException e) {
            e.printStackTrace();
        }

    }
}
