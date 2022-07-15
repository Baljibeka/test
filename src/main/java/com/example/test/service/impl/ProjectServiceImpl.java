package com.example.test.service.impl;

import com.example.test.model.Project;
import com.example.test.model.Task;
import com.example.test.repo.ProjectRepository;
import com.example.test.service.ProjectService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectrepo;

    public ProjectServiceImpl(ProjectRepository projectrepo) {
        super();
        this.projectrepo = projectrepo;
    }

    @Override
    public Optional<Project> findByIdProject(Long id) {
        return projectrepo.findById(id);
    }

    @Override
    public Project createProject(Project project) {
        return projectrepo.save(project);
    }

    @Override
    public void deleteProject(long id) {
         projectrepo.deleteById(id);
    }

    @Override
    public void updateProject(long id, Project project) {
        Project existingProject= null;
        try {
            existingProject = projectrepo.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
            existingProject.setName(project.getName());
            existingProject.setStartDate(project.getStartDate());
            existingProject.setEndDate(project.getEndDate());
            projectrepo.save(project);
        } catch (ChangeSetPersister.NotFoundException e) {
            e.printStackTrace();
        }
    }
}
