package com.example.test.controller;

import com.example.test.model.Project;
import com.example.test.model.Task;
import com.example.test.service.ProjectService;
import com.example.test.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        super();
        this.taskService=taskService;
    }

    @GetMapping("/{id}")
    public Optional<Task> findByIdProject(@PathVariable Long id){
        return taskService.findByIdTask(id);
    }

    @PostMapping
    public Task createProject(@Valid @RequestBody Task task){
        return taskService.createTask(task);
    }

    @DeleteMapping("{id}")
    public void deleteProject(@PathVariable("id") long id){
        taskService.deleteTask(id);
    }

    @PutMapping("{id}")
    public void updateProject(@PathVariable("id") long id
            ,@RequestBody Task task){
        taskService.updateTask(id, task);
    }

}
