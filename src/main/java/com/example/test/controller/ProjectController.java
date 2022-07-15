package com.example.test.controller;

import com.example.test.model.Project;
import com.example.test.model.Task;
import com.example.test.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.test.repo.ProjectRepository;
import com.example.test.repo.TaskRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        super();
        this.projectService=projectService;
    }

    @GetMapping("/{id}")
    public Optional<Project> findByIdProject(@PathVariable Long id){
        return projectService.findByIdProject(id);
    }

    @PostMapping
    public Project createProject(@Valid @RequestBody Project project){
        return projectService.createProject(project);
    }

    @DeleteMapping("{id}")
    public void deleteProject(@PathVariable("id") long id){
        projectService.deleteProject(id);
    }

    @PutMapping("{id}")
    public void updateProject(@PathVariable("id") long id
            ,@RequestBody Project project){
        projectService.updateProject(id, project);
    }

}
