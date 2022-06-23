package service;

import model.Project;
import model.Task;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface Service {
    List<Task> findAllTask();
    Optional<Task> findByIdTask(Long id);
    Task createTask(Task task);
    String deleteTask(long id);
    void updateTask(long id,Task task);
    Optional<Project> findByIdProject(Long id);
    Project createProject(Project project);
    String deleteProject(long id);
    void updateProject(long id,Project project);
}
