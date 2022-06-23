package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private Project project;
    enum status {
        ToDo,
        InProgress,
        Done
    };

    String name;
    String description;

    public Task() {

    }

    public Task(Project project, String name, String description){
        this.description=description;
        this.name=name;
        this.project=project;
    }

}
