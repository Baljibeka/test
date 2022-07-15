package com.example.test.service;

import com.example.test.model.Project;
import java.util.Optional;

public interface ProjectService {
    Optional<Project> findByIdProject(Long id);
    Project createProject(Project project);
    void deleteProject(long id);
    void updateProject(long id,Project project);
}
