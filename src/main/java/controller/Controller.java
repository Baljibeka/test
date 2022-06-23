package controller;

import model.Project;
import model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import repo.ProjectRepository;
import repo.TaskRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/control")
public class Controller {
    private final ProjectRepository projectrepo;
    private final TaskRepository taskrepo;

 @Autowired
    public Controller(ProjectRepository projectrepo, TaskRepository taskrepo) {
        this.projectrepo = projectrepo;
        this.taskrepo = taskrepo;
    }

    @GetMapping
    public List<Task> findAllTask(){
     return taskrepo.findAll();
    }


    @GetMapping("/{id}")
    public Optional<Task> findByIdTask(@PathVariable Long id){
     return taskrepo.findById(id);
    }

    @PostMapping
    public Task createTask(@Valid @RequestBody Task task){
        return taskrepo.save(task);
    }

    @DeleteMapping("{id}")
    public String deleteTask(@PathVariable("id") long id){
        taskrepo.deleteById(id);

        return "task deleted successfully!.";
    }

    @PutMapping("{id}")
    public void updateTask(@PathVariable("id") long id
            ,@RequestBody Task task){
        this.taskrepo.save(task);
        System.out.println("Saved!");
    }


    @GetMapping("/{id}")
    public Optional<Project> findByIdProject(@PathVariable Long id){
        return projectrepo.findById(id);
    }

    @PostMapping
    public Project createProject(@Valid @RequestBody Project project){
        return projectrepo.save(project);
    }

    @DeleteMapping("{id}")
    public String deleteProject(@PathVariable("id") long id){
        projectrepo.deleteById(id);

        return "project deleted successfully!.";
    }

    @PutMapping("{id}")
    public void updateProject(@PathVariable("id") long id
            ,@RequestBody Project project){
        this.projectrepo.save(project);
        System.out.println("Saved!");
    }

}
